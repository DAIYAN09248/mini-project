package com.example.mini_project.service;

import com.example.mini_project.model.Member;
import com.example.mini_project.model.Recharge;
import com.example.mini_project.repository.MemberRepository;
import com.example.mini_project.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class RechargeService {
    @Autowired
    private RechargeRepository rechargeRepository;
    
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Recharge createRecharge(Recharge recharge) {
        // Set current date/time if not provided
        if (recharge.getDateTime() == null) {
            recharge.setDateTime(new Date());
        }
        
        // Update member balance
        Member member = memberRepository.findById(recharge.getMemberId()).orElse(null);
        if (member != null) {
            double newBalance = member.getBalance() + recharge.getAmount();
            if (newBalance > 0 && newBalance < 10000) {
                member.setBalance(newBalance);
                memberRepository.save(member);
            }
        }
        
        return rechargeRepository.save(recharge);
    }
}