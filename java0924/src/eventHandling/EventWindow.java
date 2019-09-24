package eventHandling;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventWindow extends Frame {
    Button btn;
	public EventWindow() {
        this.addMouseMotionListener(
        		new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				btn.setLocation(e.getX(), e.getY());				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
				
			}
        	
        });
		
		setLayout(null);
		btn = new Button("버튼");
		btn.setBounds(30,30,50,50);
		add(btn);
		
		//현재 프레임의 키보드 이벤트(keyListener)를 처리 
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//문자 키를 눌렀을 때만 동작 
				//getKeyChar는 대소문자 구분을 합니다. 
				System.out.printf("문자:%c\n", e.getKeyChar());
				// 키보드를 누르면 무조건 동작 
				// 대소문자 구분을 하지 않습니다. 
				System.out.printf("코드:%d\n", e.getKeyCode());
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
			
		});
		
		// AWT 나 SWING은 이벤트 처리를 Delegate패턴으로 처리 
		// Delegate패턴: 이벤트가 발생한 객체가 이벤트를 처리하지 않고 
		// 별도의 객체를 만들어서 처리하도록 하는 패턴 - 위임 
		btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btn.setBackground(Color.GREEN);				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setForeground(Color.ORANGE);
				System.out.printf("x:%d y:%d\n",
						e.getX(), e.getY());
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(Color.PINK);				
			}
			
		});
		
		setBounds(200, 200, 400, 400);
		setTitle("이벤트 처리");
		setVisible(true);
		
    }
}
