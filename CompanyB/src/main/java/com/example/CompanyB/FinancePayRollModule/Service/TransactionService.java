package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import com.example.CompanyB.FinancePayRollModule.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void processPayrollTransaction(double amount) {
        Transaction transaction = new Transaction();
    //    transaction.setAmount(-amount); // Negative because it's an expense
        transaction.setTransactionDate(new Date());
        transaction.setTransactionMethod("Payroll");
        transactionRepository.save(transaction);
    }

    public void processInvoiceTransaction(double amount) {
        Transaction transaction = new Transaction();
      //  transaction.setAmount(amount); // Positive because it's an income
        transaction.setTransactionDate(new Date());
        transaction.setTransactionMethod("Invoice");
        transactionRepository.save(transaction);
    }


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
