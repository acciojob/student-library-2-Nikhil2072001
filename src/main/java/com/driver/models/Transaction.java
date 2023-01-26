package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId = UUID.randomUUID().toString(); // externalId

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("books")
    private Card card;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactions")
    private Book book;

    private int fineAmount;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean isIssueOperation;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Transaction(String transactionId, Card card, Book book, int fineAmount, boolean isIssueOperation, TransactionStatus transactionStatus, Date transactionDate) {
        this.transactionId = transactionId;
        this.card = card;
        this.book = book;
        this.fineAmount = fineAmount;
        this.isIssueOperation = isIssueOperation;
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }

    public Transaction(int id, String transactionId, Card card, Book book, int fineAmount, boolean isIssueOperation, TransactionStatus transactionStatus, Date transactionDate) {
        this.id = id;
        this.transactionId = transactionId;
        this.card = card;
        this.book = book;
        this.fineAmount = fineAmount;
        this.isIssueOperation = isIssueOperation;
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isIssueOperation() {
        return isIssueOperation;
    }

    public void setIssueOperation(boolean issueOperation) {
        isIssueOperation = issueOperation;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}