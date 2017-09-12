package com.sensy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "TemporaryCart", schema = "dbo", catalog = "BookShopPlus")
public class TemporaryCartEntity {
    private Timestamp createTime;
    private int bookId;
    private int userId;
    private int id;

    @Basic
    @Column(name = "CreateTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

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

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemporaryCartEntity that = (TemporaryCartEntity) o;

        if (bookId != that.bookId) return false;
        if (userId != that.userId) return false;
        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = createTime != null ? createTime.hashCode() : 0;
        result = 31 * result + bookId;
        result = 31 * result + userId;
        result = 31 * result + id;
        return result;
    }
}
