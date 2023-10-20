import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame =  new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];

    boolean player1_turn; // variable is going to be true if its player ones turn and false if its player 2s turn
    TicTacToe() {
// constructor
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0));

        // now dealing with the textfield

        text_field.setBackground(Color.BLACK);
        text_field.setForeground(new Color(255,255,255));
        text_field.setFont(new Font("Ink Free", Font.BOLD,75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("TIC TAC TOE");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        // setting buttons now
        button_panel.setLayout(new GridLayout(3,3)); // buttons formed in grid so there is a grid layout
        button_panel.setBackground(new Color(0,0,0));
        // buttons
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        // now we are going to set the text_field to the panel and then add the panel to the frame we made earlier on, and also add the buttons
        title_panel.add(text_field);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// for ActionListener
        for(int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if (player1_turn){
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(100));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("Player O's Turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("Player X's Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
// chooses who goes first
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(random.nextInt(2) == 0 ) {
            player1_turn = true;
            text_field.setText("Player X's turn!");
        }
        else {
            player1_turn = false;
            text_field.setText("Player O's turn!");
        }

    }
    public void check() {
        // winning conditions
        if (
                        (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            Xwins(0,1,2);
        }
        if (
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            Xwins(3,4,5);
        }
        if (
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            Xwins(6,7,8);
        }
        if (
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            Xwins(0,3,6);
        }
        if (
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            Xwins(1,4,7);
        }
        if (
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            Xwins(2,5,8);
        }
        if (
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            Xwins(0,4,8);
        }
        if (
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            Xwins(2,4,6);
        }
        // Y POSSIBLE COMBINATIONS HERE!!! // Y POSSIBLE COMBINATIONS HERE!!!// Y POSSIBLE COMBINATIONS HERE!!!// Y POSSIBLE COMBINATIONS HERE!!!
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            Owins(0,1,2);
        }
        if (
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            Owins(3,4,5);
        }
        if (
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            Owins(6,7,8);
        }
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            Owins(0,3,6);
        }
        if (
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            Owins(1,4,7);
        }
        if (
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            Owins(2,5,8);
        }
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            Owins(0,4,8);
        }
        if (
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            Owins(2,4,6);
        }
    }
    public void Xwins(int a, int b, int c) {
        // if x player wins we will call this method
        // the parameters are integers and act as if they were the button combination pressed for the win
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
            buttons[i].setOpaque(true);
        }
        text_field.setText("PLAYER X WINS");
    }
    public void Owins(int a, int b, int c) {
        // if o player wins we will call this method
        buttons[a].setForeground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
            buttons[i].setOpaque(true);
        }
        text_field.setText("PLAYER O WINS");
    }
}
