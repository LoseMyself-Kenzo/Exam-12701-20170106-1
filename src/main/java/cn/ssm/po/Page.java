package cn.ssm.po;


public class Page{
    private int page;
    private int pageSize;
    private int no;
    
    public int getPage() {
        return page;
    }

    public Page setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getOffset() {
        return (page - 1) * pageSize;
    }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}
