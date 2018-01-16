package Data;

import Main.PlayScreen;
import Network.Client;

public class CardPenalty implements Runnable{
	
	int idNum;
	int pcnt;
	public CardPenalty(int idNum,int pcnt){
		this.idNum=idNum;
		this.pcnt=pcnt;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	for(int j=0;j<pcnt;j++){
		PlayScreen.x=40;
		PlayScreen.leftcard1++;// 내 남은 카드수가 증가한다
//		System.out.println("A로세장먹였다");	  	      	  
          PlayScreen.mylist.add(PlayScreen.closelist.get(0));            
             for(int i=0;i<PlayScreen.mylist.size();i++){//나의 카드
                PlayScreen.me.add(PlayScreen.mylist.get(i));            
                 PlayScreen.mylist.get(i).setBounds(PlayScreen.x, 10, 70,100);    
                 PlayScreen.mylist.get(i).addActionListener(Client.ps);
                 PlayScreen.mylist.get(i).setEnabled(false);  
                 PlayScreen.x+=20;
             }                       
             
             Client.sendLeftCard(PlayScreen.leftcard1+"");       
               String su=0+"";//closelist의 첫번째 카드 삭제할거다                 
               Client.sendReMove(su);
               Thread thr6=new Thread(new LeftCard(idNum,PlayScreen.leftcard1));
               thr6.start();
             System.out.println("close카드"+PlayScreen.closelist.size());
		}
		PlayScreen.me.removeAll();
		PlayScreen.location1=40;
	 for(int c=0;c<PlayScreen.mylist.size();c++){  //재배치     
         PlayScreen.me.add(PlayScreen.mylist.get(c));     
         PlayScreen.mylist.get(c).setEnabled(false);
         PlayScreen.mylist.get(c).setBounds(PlayScreen.location1, 10, 70,100);     
         PlayScreen.location1+=20;              
    } 
	
	}   
	
}
