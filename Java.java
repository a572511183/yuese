package java课设;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner; 
public class Java {
	public static List<String> timulist = new ArrayList<>();//创建存储题目的集合
	public static List<Integer> userlist = new ArrayList<>();//创建存储用户计算结果的集合
	public static List<Integer> list2 = new ArrayList<>();//创建所有题目正确答案集合
	
	static int num;
	static void fun1() {
		
		System.out.println("请输入题目数量");
		 Scanner IN = new Scanner(System.in);
		  num=IN.nextInt(); 
		 Random r = new Random();
		 for(int i=0 ;i<num;i++)
		{
      int ran1 = r.nextInt(100);
      int ran2 = r.nextInt(150);
      int cint = r.nextInt(4);
      String c;
      switch (cint) {
		case 0:
		    c = "+";
		    timulist.add(ran1+c+ran2);
			list2.add(ran1+ran2);//list2为所有题目正确答案的集合
			break;
		case 1:
			c = "-";
			timulist.add(ran1+c+ran2);
			list2.add(ran1-ran2);//list2为所有题目正确答案的集合
			break;
		case 2:
			c = "*";
			timulist.add(ran1+c+ran2);
			list2.add(ran1*ran2);//list2为所有题目正确答案的集合
			break;
		default:
			c = "/";
			timulist.add(ran1+c+ran2);
			list2.add(ran1/ran2);//list2为所有题目正确答案的集合
			break;
		}

		}
		 System.out.println("题目生成成功！");  
	}
	
	
	static void fun2()
	{
		 for (int i = 0; i < timulist.size(); i++) {
	            System.out.println(timulist.get(i)+"= ?");
	        }
		 System.out.println("请回答题目，以空格分割，（注：两个数相除时取整）");
		 Scanner IN1 = new Scanner(System.in);
		 for (int i = 0; i < num; i++) {
		 int x=IN1.nextInt();
		 userlist.add(x);
		 }
		 System.out.println("答题成功，按3查看成绩！");

	}
	
	static double result,rightnum=0;
	static	void fun3()
	{
		for( int i = 0;i<userlist.size();i++){
			
			System.out.println(userlist.get(i));
			System.out.println("----------");
			System.out.println(list2.get(i));
			
			if(userlist.get(i) == list2.get(i)){//list2为所有题目正确答案的集合
				rightnum++;                   
			}
		}
		
		result = ((rightnum*1.0)/(list2.size())*100);
	System.out.println("姓名:"+name+"  "+"做题量:"+list2.size()+" "+"正确个数:"+rightnum+"\n"+"正确率："+result); 
	System.out.println("按4保存并查看排行榜");
	
	}
	
	
	
	
	//写入当前数据并读取排行榜
	static	void fun4()
	{
		method1(name,String.valueOf(result),String.valueOf(rightnum),1);
		
		
		try
		{
		FileReader fr = new FileReader("D:\\student.txt");//需要读取的文件路径bai
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		
		System.out.println("====《排行榜》===");
		while(s!=null)//如果当前行不为空
		{
		System.out.println(s);//打印当前行
		s= br.readLine();//读取下一行
		}
		br.close();//关闭BufferReader流
		fr.close(); //关闭文件流
		}catch(IOException e)//捕捉异常
		{
		System.out.println("指定文件不存在");//处理异常
		}
	} 
	
	
	
	static	void fun5()
	{
		flag=0;
		System.out.println("成功退出！");
	}
	
	
	    //排行榜
		public static void method1(String data1,String data2,String data3,int i) {
			FileWriter fw = null;
			try {
			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f=new File("D:\\student.txt");
			fw = new FileWriter(f, true);
			} catch (IOException e) {
			e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(fw);
			if(i!=0) {
				pw.println(data1+" "+data2+" "+data3);
			}
			pw.println("---------");
			pw.flush();
			try {
			fw.flush();
			pw.close();
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
			}
	
	
	   static String name;static int flag=1;
	 public static void main(String[] args) {
	        System.out.println("------------------简单算术运算测验系统------------------\r\n" + 
	        		"1.出题\r\n" + 
	        		"2.答题\r\n" + 
	        		"3.查看成绩\r\n" + 
	        		"4.排行榜\r\n" + 
	        		"5.退出\r\n");
	        
	        System.out.println("请输入您的姓名");
	        Scanner in = new Scanner(System.in);
	        name=in.next();
	        System.out.println("请选择（1-5）：");
	        method1("","","",0);//创建txt
int n;
while(flag==1) {
	n=in.nextInt();
switch(n){
    case 1 :
    	fun1();
       break; 
    case 2 :
    	fun2();
       break;
    case 3 :
    	fun3();
        break;
    case 4 :
    	fun4();
        break;
    case 5 :
    	fun5();
        break;
    default : 
    	System.out.println("输入有误");
}
System.out.println("简单算术运算测验系统\r\n" + 
		"1.出题\r\n" + 
		"2.答题\r\n" + 
		"3.查看成绩\r\n" + 
		"4.排行榜\r\n" + 
		"5.退出\r\n");
}
	    }
	 

}
