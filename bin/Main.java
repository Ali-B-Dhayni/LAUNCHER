import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static void runPythonScript(JTextArea textArea){
        try {
            // Execute Python script
            Process p = Runtime.getRuntime().exec("python C:\\Launcher\\bin\\script.py");

            // Read and print output from the script
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }

            // Wait for the process to finish
            int exitCode = p.waitFor();
            System.out.println("Python script exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
   
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Dark Mode GUI");
        frame.setSize(500, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Set dark mode colors
        Color darkBackground = new Color(43, 43, 43);
        Color darkForeground = new Color(255, 255, 255);
        // Create and style the text area


       
        // Set frame background
        frame.getContentPane().setBackground(darkBackground);
        
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setBackground(new Color(60, 60, 60));
        textArea.setForeground(darkForeground);
        textArea.setCaretColor(darkForeground);
        textArea.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setEditable(false);
        // Add scrolling capability
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 200));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
        // Create and style the text field
        JTextField textField = new JTextField(20);
        textField.setBackground(new Color(60, 60, 60));
        textField.setForeground(darkForeground);
        textField.setCaretColor(darkForeground);
        textField.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
        textField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Create and style the button
        JButton button = new JButton("Start");
        button.setBackground(new Color(75, 110, 175));
        button.setForeground(darkForeground);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.addActionListener(e -> runPythonScript(textArea));
      
        // Add components to frame
        frame.add(textField);
        frame.add(button);

        // Center the frame on screen and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
