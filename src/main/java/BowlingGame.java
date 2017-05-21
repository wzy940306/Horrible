/*
因理解错题目。本程序需手动输入分数...
--------------------------------------------------------------
绝对可以正确完成所有实例！！
--------------------------------------------------------------
X|X|X|X|X|X|X|X|X|X||XX
只需要输入 10 10 10 10 10 ..程序自动判断得分状况是否跳到下一格。
自动判断是否有额外球的机会。

9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||
输入9分后，程序会追问第二次分数，自动判断是否有spare。

X|7/|9-|X|-8|8/|-6|X|X|X||81
输入 即为：①10②7和3③9和0④10⑤0和8⑥0和6⑦ 10等等

--------------------------------------------------------------
程序员大大们好，小弟因不会Java现学现编很努力。。希望不要因为输入成绩的方式不同导致作品负分滚粗。。
*/
import java.util.Scanner;
public class BowlingGame {
	int total = 0;
	int[] arrMark = {0,0,0,0,0,0,0,0,0,0,0,0};						//利用数组存每个格子分数情况
	int[] arrBonus = {0,0,0,0,0,0,0,0,0,0,0,0};					//利用数组存每个格子额外奖励
	// int[] arrFinally = {};					//利用数组存每个格子最终分数
	int[] arrSingle = {0,0,0,0,0,0,0,0,0,0,0,0};					//利用数组存每个格子详细分数m2
   
	
	public static void main(String[] args)
		{
			BowlingGame Obj=new BowlingGame();
			getBowlingScore(Obj);	
			
		}
	
	public  static void
		getBowlingScore(BowlingGame b) 
		{
			System.out.println("计分");
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
				//System.out.println("第"+w+"次值:"+bonus(w)); 
				total += bonus(w);
			}
		

			System.out.println("总得分:"+total);	
		for ( int v =1;v<=10 ;v++ ) 
			{
				//System.out.println("第"+v+"次值:"+arrBonus[v]);	
				//System.out.println("第"+v+"次值:"+arrMark[v]);
				//System.out.println("第"+v+"次值:"+arrSingle[v]);
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
						System.out.println("输入第"+count+"次的第二次分数");
						int m2 = sc.nextInt();
						if (m2 == 10 - m1)
							{
								System.out.println("获得一个Spare,此格结束");
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
								System.out.println("输入额外第1次的分数:");
								arrMark[count+1] = sc.nextInt();
								System.out.println("输入额外第2次的分数:");
								arrSingle[count+1] = sc.nextInt();
								
								
							}	
						if (judgeM == 1)
							{
								Scanner sc = new Scanner(System.in);
								System.out.println("输入额外的分数:");
								arrMark[count+1] = sc.nextInt();
							
							}

					}
					
		
		}


	public  int getMark(int count)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入第"+count+"次分数");
			int m1 = sc.nextInt();
			return m1;
		} 



	public  int judge(int m1)
		{
			if (m1==10) 
			{
				System.out.println("获得了一个X,此格结束");
				return 2;
			}
			if (m1>=0&&m1<10)
			{	
				System.out.println("得分"+m1+"分,还有一次击球机会");
				return 1;
			}
			else
			{
				System.out.println("输入分数出错,请在0到10内输入");
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