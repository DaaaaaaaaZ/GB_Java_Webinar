package dz.geekbrains.java.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private JLabel label;
    private int randomInt;
    private JLabel labelForTry;
    private JPanel panel;
    private int tryCount = 3;
    private JButton restartButton;

    public MyWindow () {
        setTitle("Угадай число!");
        setBounds(300, 300, 400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        label = new JLabel("  ");
        label.setFont (new Font ("Arial", Font.BOLD, 17));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add (label, BorderLayout.NORTH);

        panel = new JPanel (new GridLayout(1, 10));

        for (int i = 1; i < 11; i++) {
            Button tempButton = new Button("" + i);
            int buttonIndex = i;
            tempButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tryToAnswer (buttonIndex);
                }
            });
            panel.add (tempButton);

        }

        add (panel, BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        add (panel2, BorderLayout.SOUTH);
        panel2.setPreferredSize(new Dimension(this.getWidth(), 200));

        labelForTry = new JLabel();
        labelForTry.setFont (new Font ("Arial", Font.BOLD, 14));
        panel2.add (labelForTry, BorderLayout.NORTH);

        restartButton = new JButton("Начать заново");
        restartButton.setVisible(false);
        restartButton.setFont(new Font ("Arial", Font.BOLD, 30));
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialGame();
                restartButton.setVisible(false);
            }
        });
        panel2.add (restartButton, BorderLayout.SOUTH);

        initialGame ();
        setVisible(true);
    }

    private void initialGame() {
        randomInt = (int)(Math.random () * 10 + 1);
        label.setText ("Программа загадала число. Отгадайте его.");

        for (Component b : panel.getComponents()) {
            b.setEnabled(true);
        }

        tryCount = 3;
        labelForTry.setText("Количество попыток: " + tryCount);
    }

    public void tryToAnswer (int value) {
        if (value == randomInt) {
            label.setText ("Вы угадали: это число " + randomInt);
            if (tryCount == 3) {
                labelForTry.setText("Великолепно: вы угадали с первой попытки!");
            } else {
                labelForTry.setText("   ");
            }
            for (Component b : panel.getComponents()) {
                b.setEnabled(false);
            }
            restartButton.setVisible(true);
            return;
        } else if (value > randomInt) {
            label.setText("Загаданное число меньше, чем " + value);
            tryCount--;
        } else {
            label.setText("Загаданное число больше, чем " + value);
            tryCount--;
        }

        switch (tryCount) {
            case 2: {
                labelForTry.setText("Осталось всего 2 попытки.");
            } break;
            case 1: {
                labelForTry.setText("Последний шанс угадать это число.");
            } break;
            case 0: {
                labelForTry.setText("Вы проиграли.");
                for (Component b : panel.getComponents()) {
                    b.setEnabled(false);
                }
                restartButton.setVisible(true);
            } break;
        }
    }
}
