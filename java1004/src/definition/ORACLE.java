package definition;

public class ORACLE {
/*
 
 ** 매킨토시 운영체제에는 오라클 서버가 설치가 안됨 
 =>매킨토시 운영체제에 오라클 서버를 설치하고자 하면 가상화 프로그램을 이용 
 가상으로 현재 운영체제에 다른 운영체제를 설치하는 것입니다.
 가상으로 설치하지 않고 듀얼부팅(하나의 컴퓨터에 2개이상의 운영체제를 설치)을 이용하는 것도 가능 
 매킨토시에 윈도우를 사용하고자 하면 패러럴즈를 설치하고 패러럴즈 안에 윈도우즈를 설치해서 사용
 가상화 프로그램으로 유명한 것은 VMWare가 있습니다. 
 최근에는 Docker(가상화 컨테이너)를 많이 이용 
 가상화를 이용이 가능해진 것은 하드웨어가 비약적으로 발전했기 때문입니다. 
 
 ** 오라클 서버에서 원격으로 접속 
 =>오라클에 접속하기 위해 필요한 정보 
 오라클 서버의 IP나 도메인: 192.168.0.13
 오라클서의 의 포트번호:1521 
 오라클 서버의 SID 또는 Server Name: SID는 데이터베이스 이름에 해당하는 개념이고 Service Name 은 운영체제가
 운영할 때 사용하는 서비스 이름 -Oracle 12c까지는 SID를 이용했는데 18c부터는 Service Name의 개념을 이용 
 xe라는 XID 
 4.계정(account)과 비밀번호(password) : 순서대로 user?? - user?? 
 
 => 접속 프로그램이 필요 
 접속 프로그램에 따라서는 드라이버가 필요한경우도 있습니다. 
 
 => 드라이버나 인터페이스
 
A <-> B 
서로 다른 H/W 또는 S/W는 사용하는 언어가 다르기 때문에 직접 대화할 수가 없습니다. 
둘 사이에서 중재하는 역할을 하는 소프트웨어나 규칙이 필요 
이러한 소프트웨어나 규칙을 드라이버, 인터페이스, 프로토콜이라고 부릅니다,.
소프트웨어일 때는 드라이버라고 하고 통신을 할 때는 프로토콜이라고 하고 이들은 통칭해서 인터페이스라고
하기도 합니다. 
운영체제(Operating System):H/W와 인간 사이의 인터페이스 

 **오라클 드라이버 다운로드 
 =>ojdbc6.jar: 자바1.6버전으로 만들어진 자바를 이용해서 오라클을 사용하기 위한 드라이버 
 =>오라클 웹사이트에서 다운로드 받아도 되고 오라클이 설치된 경우 jdbc/lib디렉토리에 있습니다. 
 ggangpae1.tistory.com에서 java카테고리로 이동하면 jar파일을 압축해 놓은 jar글에서 다운로드 받아도 됩니다. 
 
 ** DBeaver다운로드
 http://dbeaver.io/download/

 
 
 ** JOIN 
 =>2개의 테이블을 합쳐서 하나의 테이블을 생성 
 =>from절에 테이블 이름이 2개이상 사용됩니다. 
 =>join의 개념은 데이터베이스 뿐 아니라 최근에 데이터분석 라이브러리에서도 그 개념을 사용합니다.
   
1.Cross Join: Cartesian Product 라고도 합니다. 
=>from 절에 테이블이름을 2개이상을 기재하고 where절에 join조건이 없는 경우(2개 테이블 사이의 
컬럼비교를 하지 않는 경우) 
=>2개 테이블의 모든 조합을 가지고 새로운 테이블을 생성해서 리턴 
=> 열의 개수는 양쪽 테이블의 열의 개수를 합친 만큼 행의 개수는 양쪽 테이블의 행의 개수를 곱한 만큼 생성됩니다. 

-- EMP테이블은 8개의 열과 14개의 행으로 구성
--DEPT테이블은 3개의 열과 4개의 행으로 구성 
-- 1.Cross Join : 11개의 열과 56개의 행이 생성 
SELECT *
FROM EMP,DEPT;

2. EQUI JOIN
=>2개의 테이블에서 공통된 의미를 갖는 컬럼의 값이 동일한 경우에만 조합을 만들도록 하는 조인방식 
=>반드시 2개 테이블에 공통된 의미를 갖는 컬럼이 존재해야 합니다.
외래키(FOREIGN KEY)를 이용해서 JOIN을 합니다. 
=> 2개 컬럼의 이름은 같아도 되고 달라도 됩니다. 
2개 컬럼의 이름이 같은 경우에는 테이블이름.컬럼이름 형태로 작성해야 합니다.
테이블 생략하면 이름이 애매모호하다고 에러가 발생합니다. 
=> where절에 2개 테이블의 공통된 의미를 갖는 컬럼의 값이 동일하다는 join조건을 추가합니다. 

-- EMP테이블의 DEPTNO는 부서번호이고 DEPT테이블의 DEPTNO도 부서번호 입니다.
-- 2. 2개의 테이블에서 EQUI JOIN수행  
SELECT * 
FROM EMP, DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO; 

3. 테이블 이름에 별명 사용 
=>FROM절에서 테이블 이름뒤에 한 칸 공백을 두고 별명을 만들 수 있습니다. 
=>별명을 만들면 이후에는 원래 테이블 이름 대신에 별명을 사용해야 합니다. 
=> 별명을 사용하는 이유는 테이블의 이름이 너무 길어서 줄여쓰기 위한 목적도 있고 테이블 이름을 
조금 더 명확하게 표현하기 위해서 한글 등을 이용하기 위해서 입니다. 
=>별명을 만든 상태에서 테이블의 원래 이름을 사용하게 되면 Invalid Identifier에러가 발생 

 --EMP테이블의 이름은 e로 DEPT테이블의 이름은 d로 별명을 만들어서 위의 join을 수행 
SELECT * 
FROM EMP e, DEPT d 
WHERE e.DEPTNO = d.DEPTNO;

4. JOIN을 한후 원하는 조건에 해당하는 데이터만 추출하고자 하는 경우에는 join조건 뒤에 AND를 
기재하고 조건을 추가해주면 됩니다. 

--  DEPT 테이블의 LOC가 DALLAS인 데이터의 EMP 테이블의 ENAME과 SAL과 LOC를 확인 
--  LOC는 DEPT테이블에 존재하고 ENAME과 SAL은 EMP 테이블에 존재 
--  2개이상의 테이블에 존재하는 컬럼을 가지고 데이터를 추출해야 하는 경우에 JOIN을 사용 
SELECT      ENAME, SAL, LOC  
FROM        EMP e, DEPT d 
WHERE       e.DEPTNO = d.DEPTNO AND UPPER(LOC)= 'DALLAS'; 

--EMP테이블에 SAL이 3000이상인 데이터의 EMP테이블의 ENAME과 DEPT 테이블의 LOC를 조회 

--EMP테이블에 SAL이 3000이상인 데이터의 EMP테이블의 ENAME과 DEPT 테이블의 LOC를 조회 
SELECT   ENAME, LOC 
FROM     EMP e, DEPT d 
WHERE    e.DEPTNO = d.DEPTNO AND SAL >= 3000;

5.Non EQUI JOIN 
=>JOIN조건을 만들 때  = 를 이용하지 않는 다른 연산자를 사용하는 join 
=> 보통은 범위 내에 해당하는 데이터를 찾고자 할 때 사용 
=>SALGRADE테이블에서는 GRADE컬럼이 있고 LOSAL과 HISAL컬럼이 존재 
GRADE는 등급이고 LOSAL은 최저급여이고 HISAL최고 급여입니다. 
EMP체이블의 SAL과 = 로 비교해서 GRADE를 찾아올 수는 없습니다. 
SAL이 LOSAL보다는 크거나 같아야 하고 HISAL보다는 작거나 같냐고 비교해서 GRADE를 찾아와야 합니다. 

-- Non EQUI JOIN 
--EMP테이블의 SAL과 SALGRADE의 LOSAL 그리고 HISAL을 이용해서 
--EMP테이블의 ENAME과 SALGRADE테이블의 GRADE컬럼의 값을 조회 
SELECT ENAME, GRADE 
FROM EMP e, SALGRADE s
WHERE e.SAL >= s.LOSAL AND e.SAL <= s.HISAL;

-- 위의 경우처럼 특정한 범위내에 속한 테이블을 찾을 때는 BETWEEN 사용 가능 
SELECT ENAME, GRADE 
FROM EMP e, SALGRADE s
WHERE e.SAL BETWEEN s.LOSAL and s.HISAL;

6.Self Join
=> 동일한 테이블끼리 JOIN 
=> 하나의 테이블에 동일한 의미를 가진 컬럼이 2개 이상 존재하는 경우에 수행 
=> 인사정보테이블에서 사원 ID와 상급자 ID를 같이 갖는 경우 기르기 SNS에서 팔로우 테이블 같은 경우는 
자신의 ID와 팔로ID를 하나의 테이블에 같이 가지고 있습니다. 
이런 경우가 Self JOIN이 가능한 경우 입니다. 
=>EMP테이블에는 사원번호를 의미하는 EMPNO 가 있고 관리자의 사원번호인 MGR컬럼이 존재합니다. 
-EMP테이블에서 관리자의 이름이 'KING'인 사원의 ENAME 을 조회 

EMP테이블에서 ENAME이 KING사원의 사원번호를 조회하고 이 사원번호를 MGR로 가진 사원의 이름을 찾아와야 합니다. 

팔로우 테이블에서 내가 팔로우한 유저의 팔로우를 찾아오는 경우가 이와 비슷한 경우입니다. 
SNS에서는 이방법을 이용해서 친구 추천을 합니다. 
연관분석에서도 이방법을 사용합니다.(상품추천, 뉴스추천...)

=>Self JOIN에서는 테이블 이름에 별명을 반드시 사용해야 합니다.
동일한 테이블 이름을 사용하기 떄문에 테이블의 실제이름이 중첩되기 때문에 별명을 이용해서 구분해야 합니다. 

--EMP테이블에서 COMM이 NULL이아닌 사원을 관리자로 두고있는 사원의 ENAME과 MGR조회 
--NULL은  =나 !=로 비교하지 않고 IS NULL 또는 IS NOT NULL 로 조회  
SELECT  e2.ENAME, e2.MGR  
FROM EMP e1, EMP e2 
WHERE e1.EMPNO = e2.MGR AND e1.COMM IS NOT NULL;  

7.OUTER JOIN 
=> INNER JOIN :공통된 컬럼의 값이 양쪽에 모두 존재하는 경우에만 JOIN에 참여 
=> OUTER JOIN:공통된 컬럼의 값이 한쪽 테이블에만 존재하는 경우에도 JOIN에 참여 
=> LEFT OUTER JOIN(왼쪽테이블에만 존재하는 데이터만 참여), RIGHT OUTER JOIN(오른쪽 테이블에만 존재하는 데이터만 참여)
FULL OUTER JOIN(한쪽 테이블에만 존재하는 데이터 전부 참여) 
=> 표준 SQL에서는 JOIN을 할 때 컬럼 이름 뒤에 (+)를 추가해서 OUTER JOIN을 수행 
양쪽에 추가하는 것은 안되서 FULL OUTER JOIN은 (+)로는 못함 
=>한쪽에만 존재하는 데이터의 JOIN후 다른 테이블 컬럼의 값은 NULL이 됩니다. 
=>EMP테이블에는 DEPTNO가 40인 데이터가 없습니다. 
DEPT테이블에는 DEPTNO가 10,20,30,40이 존재합니다. 

-- EMP테이블과 DEPT테이블을 조인하는데 DEPT테이블에만 존재하는 데이터도 참여 
-- +를 추가한 쪽이 참여하는 것이 아니고 +가 없는 쪽의 데이터가 참여 
SELECT * 
FROM EMP e, DEPT d 
WHERE e.DEPTNO(+) = d.DEPTNO (AND e.DEPTNO IS NULL);
 
8.ANSI JOIN 
=>미국 표준 협회(ANSI)에서 추가할 JOIN문법 
=> 이 문법은 표준은 아니어서 사용할 수 있는 관계형 데이터베이스가 있고 사용할 수 없는 관계형 데이터베이스도 있습니다. 

1)ANSI CROSS JOIN
=>FROM절에서 테이블 이름 과 테이블 이름 사이에 CROSS JOIN 이라고 기재를 해서 CROSS JOIN을 수행 
=>CROSS JOIN은 양쪽 테이블의 모든 조합을 가지고 새로운 테이블을 만들어 내는 것 

-- EMP테이블과 DEPT테이블의 ANSI CROSS JOIN 
SELECT * 
FROM EMP CROSS JOIN DEPT;

2)  ANSI INNER JOIN 
FROM절에는 테이블 이름과 이름 사이에 INNER JOIN이라고 기재를 하고 JOIN조건을 WHERE이 아닌 ON절에 기재 
=>WHERE절에서 JOIN조건을 	WHERE앞의 ON절을 추가해서 이동 

--EMP테이블과 DEPT테이블의 ANSI INNER JOIN 
SELECT * 
FROM EMP INNER JOIN DEPT 
ON EMP.DEPTNO = DEPT.DEPTNO;
  
=>가독성이 높아지는데 개발자들은 표준이 아니라서 잘 사용하지 않음 

=>양쪽 컬럼의 조인 조건에 사용되는 컬럼의 이름이 같다면 on대신에 using을 추가해서 한번만  작성해도 됩니다.
using(공통컬럼) 

SELECT * 
FROM EMP INNER JOIN DEPT 
USING (DEPTNO);

  =>조인에 참여하는 양쪽 컬럼의 이름이 같은 경우 INNER JOIN 대신에 NATURAL JOIN이라고 기재하면 조인조건을 
  작성하지 않아도 동일한 이름으로 구성된 컬럼을 찾아서 JOIN을 수행 
  
 SELECT * 
FROM EMP NATURAL JOIN DEPT; 

3) ANSI OUTER JOIN 
=>INNER JOPIN대신에 LEFT OUTER JOIN, RIGHT OUTER JOIN, FULL OUTER JOIN이라고 기재를 하면 
OUTER JOIN을 수행 
=> ON절이나 USING 절을 이용해서 JOIN조건을 기재 

--EMP테이블과 DEPT테이블 간의 RIGHT OUTER JOIN 
SELECT * 
FROM EMP, DEPT 
WHERE EMP.DEPTNO(+) = DEPT.DEPTNO; 

SELECT * 
FROM EMP RIGHT OUTER JOIN DEPT 
ON EMP.DEPTNO = DEPT.DEPTNO; 

SELECT * 
FROM EMP RIGHT OUTER JOIN DEPT 
USING (DEPTNO); 

4)OUTER JOIN의 경우는 Full OUTER JOIN때문에 ANSI JOIN을 많이 이용합니다.
양쪽 컬럼의 이름이 같을 때 USING을 이용하면 결과가 리턴될때 동일한 컬럼이 한 번만 출력되기 때문에 
메모리를 절약할 수 있습니다. 

9.SET OPERATOR :집합 연산자 
=> 동일한 구조의 테이블끼리의 연산 
=> 테이블의 공통된 데이터를 추출하고 합치고 한쪽에만 존재하는 데이터를 찾아내는 연산 
=> 대응이 되는 컬럼끼리는 자료형이 일치해야 합니다. 
=>결과가 출력될 때는 컬럼이름은 앞 쪽에 사용된 테이블의 컬럼이름이 출력 
=>ORDER BY는 마지막에 한번 만 사용 가능 
 
 SELECT * 또는 컬럼 도는 연산식 나열 
 FROM테이블이름 나열 
 
 SET 연산자 

 SELECT * 또는 컬럼 도는 연산식 나열 
 FROM테이블이름 나열 
 
  ORDER BY 정렬할 컬럼이름 또는 연산식 ; 
  
  1)UNION 
  =>합집합을 구해주는데 동일한 데이터는 한 번만 출력 
  
  2) UNION ALL 
  =>합집합을 구해주는데 중복된 데이터도 모두 출력 
  
  3)INTERSECT 
  =>교집합을 구해주는 연산자: 양쪽에 공통된 데이터 출력 
  
   4)MINUS 
   =>차집합을 구해주는 연산자: 앞  테이블에만 존재하는 데이터 출력 
   
   5)제약사항 
   =>BLOB, CLOB, LONG, BFILE자료형은 집합연산을 수행할 수 없음 
   => 이 자료형들은 INDEX설정이 안되는 자료형 
   => INDEX는 데이터를 빠르게[ 검색하기 위해서 설정해 놓는 포인터 
   
--EMP테이블과 DEPT에 존재하는 모든 DEPTNO을 조회 
-- 이경우 JOIN을 사용하게 되면 너무 많은 데이터 조합을 만든 후에 골라내게 됩니다. 

SELECT DEPTNO 
FROM EMP 

UNION 

SELECT DEPTNO 
FROM DEPT; 
  
--EMP테이블과 DEPT테이블에 공통으로 존재하는 DEPTNO를 조회 
SELECT DEPTNO 
FROM EMP 

INTERSECT  

SELECT DEPTNO 
FROM DEPT; 

--DEPT테이블에는 존재하고 EMP테이블에는 존재하지 않는 DEPTNO를 조회 
SELECT DEPTNO 
FROM DEPT 

MINUS 

SELECT DEPTNO 
FROM EMP;

--EMP테이블에서 관리자(MGR)가 아닌 사원의 사원번호(EMPNO)를 조회
SELECT EMPNO
FROM EMP 

MINUS 

SELECT MGR 
FROM EMP; 
  
10.GROUPING SETS 
=>GROUP BY 는 그룹별로 묶을 때 사용하는 절 
이 절은 컬럼 개수에 상관없이 하나로 묶어줍니다 .
2개 이상의 그룹화가 안됩니다. 

=>GROUP BY절에 GROUPING SETS을 기재하고 ()안에 컬럼이름을 여러개를 기재하면 
각 컬럼 별로 묶어서 집계(합계,개수,평균,최대,최소,분산,표준편차)를 해줍니다

--EMP테이블에서 DEPTNO별 SAL의 합계와 JOB별 SAL의 합계를 조회하기 
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP 
GROUP BY DEPTNO, JOB;
--위처럼 하게 되면 DEPTNO와 JOB을 합친 것을 가지고 그룹화 

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP 
GROUP BY GROUPING SETS(DEPTNO, JOB);

 11. 집합연산은 JOIN으로 전부 해결할 수 있는데 집합연산으로 해결할 수있는 것들은 반드시 
 집합연산으로 해결해야 합니다.
 
** Sub Query 
=> SQL의 절에 포함된 SQL 
1.서비 쿼리 작성시 주의할 사항 
=>서브 쿼리는 반드시 괄호안에 작성 
=서비 쿼리는 포함하고 있는 쿼리보다 먼저 1번만 수행 

 2.서브 쿼리의 종류 
 => 단일 행 서비쿼리: 결과가 하나의 행인 서브쿼리 
 => 다중 행 서브쿼리: 결과가 2개이상의 행인 서브쿼리 
 => >,>=,<=, =,!= 는 단일행 연산자입니다. 
 단일 행 결과만 비교가 가능 
 => 여러 개의 행일 때는 in, not in, ANY, ALL과 같은 연산자를 이용 
ANY, ALL은 MAX MIN함수를 이용해서 해결이 가능 

3.서브 쿼리를 적절히 이용하면 join의 횟수를 줄일 수 있습니다. 

-- DEPT의 LOC가 DALLAS인 사원의 EMP테이블의 EMPNO와 ENAME을 조회 
-- 2개 테이블의 데이터를 사용 
SELECT  EMPNO, ENAME  
FROM    EMP, DEPT 
WHERE   EMP.DEPTNO = DEPT.DEPTNO AND UPPER(LOC) = 'DALLAS';

 =>조회해야 하는 컬럼이 EMPNO와 ENAME인데 이 2개의 컬럼은 EMP테이블에 존재합니다. 
 이런 경우에는 조인없이 해결이 가능합니다. 
 이 때 사용할 수 있는 것이 sub query 입니다. 
 이 경우에도 양쪽 테이블에 동일한 의미를 갖는 컬럼이 있는 경우에 가능합니다. 
 
 --서브 쿼리를 이용해서 해결 
SELECT EMPNO, ENAME
FROM EMP 
WHERE DEPTNO = (SELECT DEPTNO
                FROM DEPT 
                WHERE UPPER(LOC)= 'DALLAS')
 
 -- EMP테이블에서 ENAME이 MILLER인 사원과 동일한 DEPTNO를 가진 사원들의 
-- ENAME과 SAL을 조회 

SELECT  ENAME, SAL 
FROM    EMP 
WHERE   ENAME != 'MILLER' AND DEPTNO = (SELECT DEPTNO 
                  FROM EMP 
                  WHERE UPPER(ENAME)= 'MILLER');       

 -- EMP테이블에서 SAL이 평균SAL보다 많은 데이터의 ENAME과 SAL을 조회         
  
SELECT ENAME, SAL 
FROM   EMP 
WHERE  SAL >  (SELECT AVG(SAL) 
               FROM   EMP); 
 
4. 다중 행 서브쿼리 
=> 서브 쿼리의 결과가 2개 이상의 행으로 리턴되는 경우 
=> 다중행 연산자를 사용해서 다중행 서브쿼리와는 비교를 해야합니다. 

in: ~에 속한 
NOT IN: ~에 속하지 않은 
=> =, !=대신에 사용 

 ANY: 하나라도 만족하면 
 ALL: 모두 만족하면 
 >,>=,<,<=와 함꼐 사용 - MAX와 MIN을 적절히 이용하면 ANY 와 ALL없이도 해결 가능 

-- EMP테이블에서 SAL이 3000이상인 사원과 동일한 DEPTNO를 가진 부서에 근무하는 사원의 
-- ENAME, SAL, DEPTNO를 조회  
-- SAL이 3000이상인 사원의 부서번호가 10,20 2개라서 단일행 연산자로는 해결할 수 없음 

SELECT ENAME, SAL, DEPTNO 
FROM EMP 
WHERE DEPTNO = (SELECT DISTINCT DEPTNO 
                FROM EMP 
                WHERE SAL>= 3000); 
=>위처럼 사용하게 되면 DEPTNO가 10,20 2개이기 때문에 오류가 발생 

SELECT ENAME, SAL, DEPTNO 
FROM EMP 
WHERE DEPTNO in (SELECT DISTINCT DEPTNO 
                FROM EMP 
                WHERE SAL>= 3000);
 
--EMP테이블에서 DEPTNO가 30인 사원들 전체보다 SAL이 많은 사원의 ENAME과 SAL을 조회 
DEPTNO가 30번인 사원이 한명이 아니기 때문에 SAL을 조회하면 2개 이상의 데이터가 리턴 
단순하게  > 로 비교하게 되면 이전에 발생했던 에러처럼 >는 2개이상의 데이터와 비교할 수 없다고 에러를 발생합니다.
이때는 >에 ALL을 추가해서 해결이 가능 
MAX(SAL)보다 커도 됩니다.  
 
 --EMP테이블에서 DEPTNO가 30인 사원들 전체보다 SAL이 많은 사원의 ENAME과 SAL을 조회 
SELECT ENAME, SAL 
FROM EMP 
WHERE SAL  >    (SELECT SAL
                 FROM   EMP 
                 WHERE  DEPTNO = 30);
               
SELECT ENAME, SAL 
FROM EMP 
WHERE SAL  > ALL(SELECT SAL
                 FROM   EMP 
                 WHERE  DEPTNO = 30);

SELECT ENAME, SAL 
FROM EMP 
WHERE SAL  > (SELECT MAX(SAL)
              FROM   EMP 
              WHERE  DEPTNO = 30);
 
 
 
 
 
 
 
 
               

  
  

  
  
  
  
  
  
  

 */
}
