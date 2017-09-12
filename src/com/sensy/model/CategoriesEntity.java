package com.sensy.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "Categories", schema = "dbo", catalog = "BookShopPlus")
public class CategoriesEntity {
    private int id;
    private String name;
    private Integer pId;
    private Integer sortNum;
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

    @Basic
    @Column(name = "PId", nullable = true)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "SortNum", nullable = true)
    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesEntity that = (CategoriesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pId != null ? !pId.equals(that.pId) : that.pId != null) return false;
        if (sortNum != null ? !sortNum.equals(that.sortNum) : that.sortNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        result = 31 * result + (sortNum != null ? sortNum.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoriesByCategoryId")
    public Collection<BooksEntity> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<BooksEntity> booksById) {
        this.booksById = booksById;
    }
}
