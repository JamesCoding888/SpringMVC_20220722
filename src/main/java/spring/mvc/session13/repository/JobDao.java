package spring.mvc.session13.repository;
import java.util.List;

public interface JobDao {
	// 每頁筆數
	int LIMIT = 5;
	
	// 新增
	int add(JobDao jobDao);
	
	// 修改
	int update(JobDao jobDao);
	
	// 刪除
	int delete(JobDao jobDao);
	

	// 查詢所有筆數
	int getCount();
	
	// 單筆查詢
	JobDao get(Integer jid);
	
	// 不分頁的查詢
	List<JobDao> query();
	
	// 分頁查詢 (判斷 HttpSession 值，決定分頁狀態)
	List<JobDao> query(Object httpSessionValue);
	
	// 分頁查詢
	List<JobDao> queryPage(int offset); // offset meaning: 到時要查到哪個位置
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
