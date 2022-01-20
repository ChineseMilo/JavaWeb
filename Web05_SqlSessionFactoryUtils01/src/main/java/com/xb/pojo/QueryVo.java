package com.xb.pojo;

public class QueryVo {
    private Long currentPage;
    private Integer pageSize;
    private User queryCondition;
    private Long offset;

    public QueryVo() {
    }

    public QueryVo(Long currentPage, Integer pageSize, User queryCondition) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.queryCondition = queryCondition;
        this.offset = offset;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public User getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(User queryCondition) {
        this.queryCondition = queryCondition;
    }

    public Long getOffset() {
        return (currentPage-1)*pageSize;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", queryCondition=" + queryCondition +
                ", offset=" + offset +
                '}';
    }
}
