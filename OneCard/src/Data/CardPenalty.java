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
		PlayScreen.leftcard1++;// �� ���� ī����� �����Ѵ�
//		System.out.println("A�μ���Կ���");	  	      	  
          PlayScreen.mylist.add(PlayScreen.closelist.get(0));            
             for(int i=0;i<PlayScreen.mylist.size();i++){//���� ī��
                PlayScreen.me.add(PlayScreen.mylist.get(i));            
                 PlayScreen.mylist.get(i).setBounds(PlayScreen.x, 10, 70,100);    
                 PlayScreen.mylist.get(i).addActionListener(Client.ps);
                 PlayScreen.mylist.get(i).setEnabled(false);  
                 PlayScreen.x+=20;
             }                       
             
             Client.sendLeftCard(PlayScreen.leftcard1+"");       
               String su=0+"";//closelist�� ù��° ī�� �����ҰŴ�                 
               Client.sendReMove(su);
               Thread thr6=new Thread(new LeftCard(idNum,PlayScreen.leftcard1));
               thr6.start();
             System.out.println("closeī��"+PlayScreen.closelist.size());
		}
		PlayScreen.me.removeAll();
		PlayScreen.location1=40;
	 for(int c=0;c<PlayScreen.mylist.size();c++){  //���ġ     
         PlayScreen.me.add(PlayScreen.mylist.get(c));     
         PlayScreen.mylist.get(c).setEnabled(false);
         PlayScreen.mylist.get(c).setBounds(PlayScreen.location1, 10, 70,100);     
         PlayScreen.location1+=20;              
    } 
	
	}   
	
}
