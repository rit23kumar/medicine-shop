package com.medicineshop.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MedStock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_stock_seq_gen")
    @SequenceGenerator(name = "med_stock_seq_gen", sequenceName = "med_stock_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "med_id")
    private Medicine medicine;

    private LocalDate expDate;
    private int quantity;
    private double price;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Medicine getMedicine() { return medicine; }
    public void setMedicine(Medicine medicine) { this.medicine = medicine; }

    public LocalDate getExpDate() { return expDate; }
    public void setExpDate(LocalDate expDate) { this.expDate = expDate; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}