package com.sensy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "ReaderComments", schema = "dbo", catalog = "BookShopPlus")
public class ReaderCommentsEntity {
    private int id;
    private int bookId;
    private String readerName;
    private String title;
    private String comment;
    private Timestamp date;
    private BooksEntity booksByBookId;

    @Basic
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BookId", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Id
    @Column(name = "ReaderName", nullable = false, length = 10)
    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Comment", nullable = false, length = 300)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReaderCommentsEntity that = (ReaderCommentsEntity) o;

        if (id != that.id) return false;
        if (bookId != that.bookId) return false;
        if (readerName != null ? !readerName.equals(that.readerName) : that.readerName != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookId;
        result = 31 * result + (readerName != null ? readerName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BookId", referencedColumnName = "Id", nullable = false)
    public BooksEntity getBooksByBookId() {
        return booksByBookId;
    }

    public void setBooksByBookId(BooksEntity booksByBookId) {
        this.booksByBookId = booksByBookId;
    }
}
