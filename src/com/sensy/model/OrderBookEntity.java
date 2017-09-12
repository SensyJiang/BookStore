package com.sensy.model;

import javax.persistence.*;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "OrderBook", schema = "dbo", catalog = "BookShopPlus")
public class OrderBookEntity {
    private int id;
    private int orderId;
    private int bookId;
    private int quantity;
    private Double unitPrice;
    private OrdersEntity ordersByOrderId;
    private BooksEntity booksByBookId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OrderID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "BookID", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "UnitPrice", nullable = false)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderBookEntity that = (OrderBookEntity) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (bookId != that.bookId) return false;
        if (quantity != that.quantity) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + orderId;
        result = 31 * result + bookId;
        result = 31 * result + quantity;
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "Id", nullable = false)
    public OrdersEntity getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(OrdersEntity ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "BookID", referencedColumnName = "Id", nullable = false)
    public BooksEntity getBooksByBookId() {
        return booksByBookId;
    }

    public void setBooksByBookId(BooksEntity booksByBookId) {
        this.booksByBookId = booksByBookId;
    }
}
