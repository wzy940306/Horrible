/*
��������Ŀ�����������ֶ��������...
--------------------------------------------------------------
���Կ�����ȷ�������ʵ������
--------------------------------------------------------------
X|X|X|X|X|X|X|X|X|X||XX
ֻ��Ҫ���� 10 10 10 10 10 ..�����Զ��жϵ÷�״���Ƿ�������һ��
�Զ��ж��Ƿ��ж�����Ļ��ᡣ

9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||
����9�ֺ󣬳����׷�ʵڶ��η������Զ��ж��Ƿ���spare��

X|7/|9-|X|-8|8/|-6|X|X|X||81
���� ��Ϊ����10��7��3��9��0��10��0��8��0��6�� 10�ȵ�

--------------------------------------------------------------
����Ա����Ǻã�С���򲻻�Java��ѧ�ֱ��Ŭ������ϣ����Ҫ��Ϊ����ɼ��ķ�ʽ��ͬ������Ʒ���ֹ��֡���
*/
import java.util.Scanner;
public class BowlingGame {
	int total = 0;
	int[] arrMark = {0,0,0,0,0,0,0,0,0,0,0,0};						//���������ÿ�����ӷ������
	int[] arrBonus = {0,0,0,0,0,0,0,0,0,0,0,0};					//���������ÿ�����Ӷ��⽱��
	// int[] arrFinally = {};					//���������ÿ���������շ���
	int[] arrSingle = {0,0,0,0,0,0,0,0,0,0,0,0};					//���������ÿ��������ϸ����m2
   
	
	public static void main(String[] args)
		{
			BowlingGame Obj=new BowlingGame();
			getBowlingScore(Obj);	
			
		}
	
	public  static void
		getBowlingScore(BowlingGame b) 
		{
			System.out.println("�Ʒ�");
			b.totalMark();
			
	    }
	public  void totalMark()
		{
			
		for (int count=1;count<=10 ;count++ )
			{ 
				array(count);
			}
		for (int w=1;w<=10 ;w++ )
			{
				//System.out.println("��"+w+"��ֵ:"+bonus(w)); 
				total += bonus(w);
			}
		

			System.out.println("�ܵ÷�:"+total);	
		for ( int v =1;v<=10 ;v++ ) 
			{
				//System.out.println("��"+v+"��ֵ:"+arrBonus[v]);	
				//System.out.println("��"+v+"��ֵ:"+arrMark[v]);
				//System.out.println("��"+v+"��ֵ:"+arrSingle[v]);
			}
		
		}
	public  void array(int count)
		{
				int m1 = getMark(count);
				int judgeM = judge(m1);
				if (judgeM == 2)
					{
						
						arrBonus[count] = 2;
						arrMark[count] = 10;
						arrSingle[count] = 0;
					}
				if (judgeM == 1)
					{
						
						Scanner sc = new Scanner(System.in);
						System.out.println("�����"+count+"�εĵڶ��η���");
						int m2 = sc.nextInt();
						if (m2 == 10 - m1)
							{
								System.out.println("���һ��Spare,�˸����");
								arrMark[count] = m1;
								arrSingle[count] = m2;
								arrBonus[count] = 1;
							}
					
						else
							{  
								arrMark[count] = m1;
								arrSingle[count] = m2;
								arrBonus[count] = 0;
								
							}
					}
				if (count == 10)
					{
						if (judgeM == 2)
							{
								Scanner sc = new Scanner(System.in);
								System.out.println("��������1�εķ���:");
								arrMark[count+1] = sc.nextInt();
								System.out.println("��������2�εķ���:");
								arrSingle[count+1] = sc.nextInt();
								
								
							}	
						if (judgeM == 1)
							{
								Scanner sc = new Scanner(System.in);
								System.out.println("�������ķ���:");
								arrMark[count+1] = sc.nextInt();
							
							}

					}
					
		
		}


	public  int getMark(int count)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("�������"+count+"�η���");
			int m1 = sc.nextInt();
			return m1;
		} 



	public  int judge(int m1)
		{
			if (m1==10) 
			{
				System.out.println("�����һ��X,�˸����");
				return 2;
			}
			if (m1>=0&&m1<10)
			{	
				System.out.println("�÷�"+m1+"��,����һ�λ������");
				return 1;
			}
			else
			{
				System.out.println("�����������,����0��10������");
				return 0;
			}
		}
	public  int bonus(int w)
			{
				
					int b = 0;
					if (arrBonus[w]==2) 
					{
						if (arrBonus[w+1]==2)
							{
								if (arrBonus[w+2]==2)
									{
										b = 30 ;
									}
								//if (arrBonus[w+2]==1 )
								else
									{
										b = 20+arrMark[w+2];
									}
							}
						else if (arrBonus[w+1]==1)
							{
								b = 20	;
							}
						else
							{
								b = 10+arrMark[w+1]+arrSingle[w+1];
							}
						
					}

					if (arrBonus[w]==1)
						{
							if (arrBonus[w]==2) 
								{
									b = 20;
								}
							else 
								{
									b = 10+ arrMark[w+1];
								}
							
						}
					if (arrBonus[w]==0)
						{
							b = arrMark[w]+arrSingle[w];
						}
				return b ;
			}
}