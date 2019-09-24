package eventHandling;

import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//WindowAdaptor는 필요한 메소드만 사용 가능 
public class EventHandler2 extends WindowAdapter
    implements  KeyListener {
    
	//KeyFrame의 Label에 대한 참조를 저장할 변수 
	Label lbl;
	
	//레이블을 주입받기 위한 생성자를 생성 
	  public EventHandler2(Label lbl) {
		  //입력하지 않아도 첫번쨰 줄은 super()
		  //상위클래스의 매개변수가 없는 생성자를 호출하는 구문 
		  //super();
			this.lbl = lbl;
		}
	
	
 
// 닫기 버튼을 누를 때 호출되는 메소드 
	@Override
	public void windowClosing(WindowEvent e) {
		//프로그램 종료
		System.exit(0); 
	}
    // 종료가 될 때 

	@Override
	public void keyTyped(KeyEvent e) {
			
	}
	@Override
	public void keyPressed(KeyEvent e) {
	    //lbl의 좌표 가져오기 
		int x = lbl.getX();
		int y = lbl.getY(); 
		//방향키를 누르면 
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 5; 
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 5;
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			y -= 5;
		}  else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y +=5;
		}
		System.out.printf(
				"조합키:%d\n", e.getModifiers());
		System.out.printf("누른 문자:%c\n", e.getKeyChar());
		System.out.printf("누른 키보드 코드:%d\n", 
				e.getKeyCode());
		
		//CTRL + X 를 누르면 프로그램 종료 
		if(e.getModifiers() == 4
			    && e.getKeyCode() == 88) {
			System.exit(0);
		}
		
	    lbl.setLocation(x, y);
	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
			
	}

}
