package java����;
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
	public static List<String> timulist = new ArrayList<>();//�����洢��Ŀ�ļ���
	public static List<Integer> userlist = new ArrayList<>();//�����洢�û��������ļ���
	public static List<Integer> list2 = new ArrayList<>();//����������Ŀ��ȷ�𰸼���
	
	static int num;
	static void fun1() {
		
		System.out.println("��������Ŀ����");
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
			list2.add(ran1+ran2);//list2Ϊ������Ŀ��ȷ�𰸵ļ���
			break;
		case 1:
			c = "-";
			timulist.add(ran1+c+ran2);
			list2.add(ran1-ran2);//list2Ϊ������Ŀ��ȷ�𰸵ļ���
			break;
		case 2:
			c = "*";
			timulist.add(ran1+c+ran2);
			list2.add(ran1*ran2);//list2Ϊ������Ŀ��ȷ�𰸵ļ���
			break;
		default:
			c = "/";
			timulist.add(ran1+c+ran2);
			list2.add(ran1/ran2);//list2Ϊ������Ŀ��ȷ�𰸵ļ���
			break;
		}

		}
		 System.out.println("��Ŀ���ɳɹ���");  
	}
	
	
	static void fun2()
	{
		 for (int i = 0; i < timulist.size(); i++) {
	            System.out.println(timulist.get(i)+"= ?");
	        }
		 System.out.println("��ش���Ŀ���Կո�ָ��ע�����������ʱȡ����");
		 Scanner IN1 = new Scanner(System.in);
		 for (int i = 0; i < num; i++) {
		 int x=IN1.nextInt();
		 userlist.add(x);
		 }
		 System.out.println("����ɹ�����3�鿴�ɼ���");

	}
	
	static double result,rightnum=0;
	static	void fun3()
	{
		for( int i = 0;i<userlist.size();i++){
			
			System.out.println(userlist.get(i));
			System.out.println("----------");
			System.out.println(list2.get(i));
			
			if(userlist.get(i) == list2.get(i)){//list2Ϊ������Ŀ��ȷ�𰸵ļ���
				rightnum++;                   
			}
		}
		
		result = ((rightnum*1.0)/(list2.size())*100);
	System.out.println("����:"+name+"  "+"������:"+list2.size()+" "+"��ȷ����:"+rightnum+"\n"+"��ȷ�ʣ�"+result); 
	System.out.println("��4���沢�鿴���а�");
	
	}
	
	
	
	
	//д�뵱ǰ���ݲ���ȡ���а�
	static	void fun4()
	{
		method1(name,String.valueOf(result),String.valueOf(rightnum),1);
		
		
		try
		{
		FileReader fr = new FileReader("D:\\student.txt");//��Ҫ��ȡ���ļ�·��bai
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		
		System.out.println("====�����а�===");
		while(s!=null)//�����ǰ�в�Ϊ��
		{
		System.out.println(s);//��ӡ��ǰ��
		s= br.readLine();//��ȡ��һ��
		}
		br.close();//�ر�BufferReader��
		fr.close(); //�ر��ļ���
		}catch(IOException e)//��׽�쳣
		{
		System.out.println("ָ���ļ�������");//�����쳣
		}
	} 
	
	
	
	static	void fun5()
	{
		flag=0;
		System.out.println("�ɹ��˳���");
	}
	
	
	    //���а�
		public static void method1(String data1,String data2,String data3,int i) {
			FileWriter fw = null;
			try {
			//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
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
	        System.out.println("------------------�������������ϵͳ------------------\r\n" + 
	        		"1.����\r\n" + 
	        		"2.����\r\n" + 
	        		"3.�鿴�ɼ�\r\n" + 
	        		"4.���а�\r\n" + 
	        		"5.�˳�\r\n");
	        
	        System.out.println("��������������");
	        Scanner in = new Scanner(System.in);
	        name=in.next();
	        System.out.println("��ѡ��1-5����");
	        method1("","","",0);//����txt
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
    	System.out.println("��������");
}
System.out.println("�������������ϵͳ\r\n" + 
		"1.����\r\n" + 
		"2.����\r\n" + 
		"3.�鿴�ɼ�\r\n" + 
		"4.���а�\r\n" + 
		"5.�˳�\r\n");
}
	    }
	 

}
