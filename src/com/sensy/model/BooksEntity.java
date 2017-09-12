package com.sensy.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "Books", schema = "dbo", catalog = "BookShopPlus")
public class BooksEntity {
    private int id;
    private String title;
    private String author;
    private int publisherId;
    private Timestamp publishDate;
    private String isbn;
    private Double unitPrice;
    private String contentDescription;
    private String toc;
    private int categoryId;
    private int clicks;
    private PublishersEntity publishersByPublisherId;
    private CategoriesEntity categoriesByCategoryId;
    private Collection<OrderBookEntity> orderBooksById;
    private Collection<ReaderCommentsEntity> readerCommentsById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Author", nullable = false, length = 200)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "PublisherId", nullable = false)
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Basic
    @Column(name = "PublishDate", nullable = false)
    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "ISBN", nullable = false, length = 50)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "UnitPrice", nullable = false)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "ContentDescription", nullable = true, length = 2147483647)
    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    @Basic
    @Column(name = "TOC", nullable = true, length = 2147483647)
    public String getToc() {
        return toc;
    }

    public void setToc(String toc) {
        this.toc = toc;
    }

    @Basic
    @Column(name = "CategoryId", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "Clicks", nullable = false)
    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (id != that.id) return false;
        if (publisherId != that.publisherId) return false;
        if (categoryId != that.categoryId) return false;
        if (clicks != that.clicks) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (publishDate != null ? !publishDate.equals(that.publishDate) : that.publishDate != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (contentDescription != null ? !contentDescription.equals(that.contentDescription) : that.contentDescription != null)
            return false;
        if (toc != null ? !toc.equals(that.toc) : that.toc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + publisherId;
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (contentDescription != null ? contentDescription.hashCode() : 0);
        result = 31 * result + (toc != null ? toc.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + clicks;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id", nullable = false)
    public PublishersEntity getPublishersByPublisherId() {
        return publishersByPublisherId;
    }

    public void setPublishersByPublisherId(PublishersEntity publishersByPublisherId) {
        this.publishersByPublisherId = publishersByPublisherId;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id", nullable = false)
    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @OneToMany(mappedBy = "booksByBookId")
    public Collection<OrderBookEntity> getOrderBooksById() {
        return orderBooksById;
    }

    public void setOrderBooksById(Collection<OrderBookEntity> orderBooksById) {
        this.orderBooksById = orderBooksById;
    }

    @OneToMany(mappedBy = "booksByBookId")
    public Collection<ReaderCommentsEntity> getReaderCommentsById() {
        return readerCommentsById;
    }

    public void setReaderCommentsById(Collection<ReaderCommentsEntity> readerCommentsById) {
        this.readerCommentsById = readerCommentsById;
    }
}
