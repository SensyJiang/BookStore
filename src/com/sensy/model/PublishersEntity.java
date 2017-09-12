package com.sensy.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "Publishers", schema = "dbo", catalog = "BookShopPlus")
public class PublishersEntity {
    private int id;
    private String name;
    private Collection<BooksEntity> booksById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublishersEntity that = (PublishersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "publishersByPublisherId")
    public Collection<BooksEntity> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<BooksEntity> booksById) {
        this.booksById = booksById;
    }
}
