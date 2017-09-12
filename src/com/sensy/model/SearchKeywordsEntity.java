package com.sensy.model;

import javax.persistence.*;

/**
 * Create by Sensy on 2017/9/12
 */
@Entity
@Table(name = "SearchKeywords", schema = "dbo", catalog = "BookShopPlus")
public class SearchKeywordsEntity {
    private int id;
    private String keyword;
    private int searchCount;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Keyword", nullable = false, length = 50)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "SearchCount", nullable = false)
    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchKeywordsEntity that = (SearchKeywordsEntity) o;

        if (id != that.id) return false;
        if (searchCount != that.searchCount) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + searchCount;
        return result;
    }
}
