package com.example.mini_project.service;

import com.example.mini_project.model.Game;
import com.example.mini_project.model.Member;
import com.example.mini_project.model.Transaction;
import com.example.mini_project.repository.GameRepository;
import com.example.mini_project.repository.MemberRepository;
import com.example.mini_project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        // Set current date if not provided
        if (transaction.getDate() == null) {
            transaction.setDate(new Date());
        }
        
        // Validate game exists and get price
        Game game = gameRepository.findById(transaction.getGameId()).orElse(null);
        if (game == null) {
            throw new IllegalArgumentException("Game not found");
        }
        
        // Validate amount is multiple of game price
        if (transaction.getAmount() % game.getPrice() != 0) {
            throw new IllegalArgumentException("Amount must be a multiple of game price");
        }
        
        // Update member balance
        Member member = memberRepository.findById(transaction.getMemberId()).orElse(null);
        if (member != null) {
            double newBalance = member.getBalance() - transaction.getAmount();
            if (newBalance >= 0) {
                member.setBalance(newBalance);
                memberRepository.save(member);
            } else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        }
        
        return transactionRepository.save(transaction);
    }
}