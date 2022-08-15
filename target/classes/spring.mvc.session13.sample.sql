-- MySQL schema: web2_springmvc
-- ============================================================================

-- 建立 Employee 資料表
create table IF NOT EXISTS employee (
    eid integer PRIMARY KEY NOT NULL AUTO_INCREMENT, -- 主鍵，員工 id (自行產生序號: 1, 2, 3, ...)
    ename varchar(50), -- 員工姓名
    salary integer, -- 員工薪資
    createtime datetime default current_timestamp -- 建檔時間
);

-- 建立 Job 資料表
create table IF NOT EXISTS job(
    jid integer PRIMARY KEY NOT NULL AUTO_INCREMENT, -- 主鍵，工作 id
    jname varchar(50), -- 工作名稱
    eid integer not null, -- 員工 id
    foreign key(eid) references employee(eid) -- 外鍵關聯
);

-- 建立 Employee 範例資料
insert into employee(ename, salary) values('John', 40000);
insert into employee(ename, salary) values('Mary', 50000);
insert into employee(ename, salary) values('Bobo', 60000);
insert into employee(ename, salary) values('Mark', 70000);

-- 建立 Job 範例資料
insert into job(jname, eid) values('Job A', 1);
insert into job(jname, eid) values('Job B', 1);
insert into job(jname, eid) values('Job C', 2);
insert into job(jname, eid) values('Job D', 2);
insert into job(jname, eid) values('Job E', 4);
insert into job(jname, eid) values('Job F', 4);
insert into job(jname, eid) values('Job G', 4);


select e.eid, e.ename, e.salary, e.createtime,
	   j.jid, j.jname, j.eid
       from employee e left join job j on e.eid = j.eid;

select e.eid, e.ename, e.salary, e.createtime,
	   j.jid as job_jid, j.jname as job_jname, j.eid as job_eid
       from employee e left join job j on e.eid = j.eid;
     
       
select * from employee;
select * from job;
select ename, salary, jname from web2_springmvc.employee where eid=1; -- 一對多，不可這樣查
select ename, salary from web2_springmvc.employee where eid=1;

-- 新增一筆資料，但 job table 的 columns 都為 null
insert into employee values (5, 'Tom', 90000, '2022-08-12 19:40:59');

select j.jid, j.jname, j.eid, 
	   e.eid as employee_eid, e.ename as employee_ename, 
       e.salary as employee_salary, e.createtime as employee_createtime
from job j left join employee e on j.eid = e.eid;


-- 透過 offset 來做分頁
select * from job limit 5 offset 0; -- offset 0 從第 1 頁開始處理
select * from job limit 5 offset 5; -- offset 5 從第 6 頁開始處理


