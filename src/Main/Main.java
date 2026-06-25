/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import auth.Login;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import java.awt.Font;

public class Main {

    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();

            UIManager.put("Button.arc", 8);
            UIManager.put("Component.arc", 8);
            UIManager.put("TabbedPane.showTabSeparators", true);
            UIManager.put("ScrollBar.thumbArc", 8);
            UIManager.put("ScrollBar.thumbInsets", new InsetsUIResource(2, 2, 2, 2));

            UIManager.put("Table.rowHeight", 28);
            UIManager.put("Table.showHorizontalLines", false);
            UIManager.put("Table.showVerticalLines", false);
            UIManager.put("Table.intercellSpacing", new java.awt.Dimension(0, 0));
            UIManager.put("Table.alternateRowColor", new ColorUIResource(245, 247, 250));
            UIManager.put("TableHeader.background", new ColorUIResource(44, 62, 80));
            UIManager.put("TableHeader.foreground", new ColorUIResource(255, 255, 255));
            UIManager.put("TableHeader.font", UIManager.getFont("Table.font").deriveFont(Font.BOLD, 13));
            UIManager.put("TableHeader.height", 32);

            UIManager.put("Panel.background", new ColorUIResource(236, 240, 241));

        } catch(Exception e) {
            e.printStackTrace();
        }

        new Login().setVisible(true);
    }
    }
    
