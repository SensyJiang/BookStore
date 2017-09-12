package com.sensy.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "RecomBooks", schema = "dbo", catalog = "BookShopPlus")
public class RecomBooksEntity {
    private int bookId;
    private int userId;

    @Basic
    @Column(name = "BookId", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "UserId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecomBooksEntity that = (RecomBooksEntity) o;

        if (bookId != that.bookId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + userId;
        return result;
    }
}
