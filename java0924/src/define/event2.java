package define;

public class event2 {
/*
 **MouseEvent 
 =>마우스를 누르거나 컴포넌트 안에 진입하거나 벗어날 때 이벤트를 처리
 =>MouseListener가 처리 
 =>MouseClicked, mouseEntered, mouseExited, mousePressed, mouseReleased메소드가 존재 
 => 이벤트처리 메소드의 매개변수는 MouseEvent 클래스의 객체 
 MouseEvent클래스에는 getX(), getY()메소드가 있어서 마우스이벤트가 발생한 좌표를 리턴 
 getClickCount()를 이용해서 클릭한 횟수를 리턴
 getPoint()도 좌표를 리턴하는데 x와 y값을 갖는 클래스의 객체로 리턴 
 => Entered대신에 Hover라고 하기도 합니다. 
 웹에서 Hover이벤트를 이용해서 메뉴를 구현하기도 합니다. 

  =>버튼 위에 마우스가 올라가면 버튼의 배경색을 파란색으로 변경하고 마우스가 빠져나오면 녹색으로 변경하기 
  
  윈도우 생성 -> 화면구성-> 필요한 이벤트를 처리 
  Frame은 BorderLayout: Frame의Layout을 변경하지 않고 바로 컴포넌트를 배치하면 컴퍼넌트가 화면 전체를 
  차지하게 됩니다.  

  **MouseMotionEvent 
  =>마우스가 움직일때 발생하는 이벤트를 처리 
  =>MouseMotionListener 가 처리 
  => 마우스를 드래그할 때 처리를 위한 mouseDragged메소드와 마우스를 움직일 때 처리를 위한 
  mouseMoved메소드가 존재 
  =>매개변수는 MouseEvent 
  
   현재 프레임에 마우스 모션 이벤트를 처리 
   마우스를 드래그할 때 버튼이 따라 오도록 처리  
  
**키보드 이벤트 
=>KeyListener가 처리 
=>kwyPressed -> keyTyped -> keyReleased메소드가 이벤트를 처리 
키보드를 누르면 keyPressed가 호출되고 키보드에서 손을 떼면 keyReleased가 호출 
keyTyped는 키보드 이벤트가 발생하고 누른 키가 문자이면 호출되는 메소드 
=>메소드의 매개변수는 keyEvent클래스의 객체이고 getKeyChar()메소드를 소유하고 있는데 
누른 문자값을 가져오고 getKeyCode()메소드는 누른 키의 숫자를 리턴합니다.
=>문자키를 눌렀을 때 는 2개의 메소드 모두 사용이 가능하지만 문자 이외의 키를 눌렀을 때 는 getKeyCode()
만 사용이 가능합니다. 
키값은 keyEvent클래스의 상수로 정의 되어 있습니다. 
keyEvent.상수형태로 이용이 가능합니다. 


** 윈도우 이벤트 
=> 윈도우에 변화가 생기는 이벤트 
=> WindowListener 가 처리 
=> 아이콘화를 처리해주는 메소드, 창닫기 버튼을 눌렀을 때 처리하는 메소드 등을 소유 
=> 이벤트를 처리 할 수 있는 객체는 Frame입니다. 
=>닫기 버튼을 누르면 windowClosing메소드가 호출 
여기서 프로그램 종료(System.exit())를 해주면 됩니다. 
실제 애플리케이션에서 구현할 때는 마지막 저장 여부를 확인해서 대화상자를 출력하는 코드를 추가 

=> 화면클래스와 이벤트처리 클래스를 분할해서 구현 
역할 별로 분리해서 프로그래밍 하는 것이 유지보수에 유리합니다. 
화면에는 레이블만 배치 
Frame에 키보드 이벤트가 발생하면 레이블을 이동(컴포넌트의 크기변화나 좌표 변화를 줄려면
 레이아웃이null이어야 합니다.) 
닫기 버튼을 누르면 윈도우가 종료되도록 코드를 작성 
 
  **Adapter Class 
  =>Listener중에서 메소드를 2개이상 가진 것들을 추상클래스로 만들어 놓은 것 
  =>이벤트처리 메소드를 전부 내용이 없는 상태로 구현해 둔 클래스 
  =>인터페이스는 추상메소드와 final상수만을 가지고 있습니다. 
  => 추상메소드는 반드시 오버라이딩을 해야합니다. 
  인터페이스를 가지고 이벤트 처리를 하게되면  메소드를 사용하지 않더라도 반드시 구현을 해야합니다. 
  Adapter Class를 이용하면 필요한 메소드만 오버라이딩 하면 됩니다.  






   
  
 
 */
}
