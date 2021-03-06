package com.picgure.ui.analysis;

import com.picgure.logging.PicgureLogger;

import javax.swing.*;
import java.util.logging.Logger;

/*
 * @author Jeet Prakash
 * */
public class LocalAnalysisFrame extends JFrame {

    private static Logger logger = PicgureLogger.getLogger(LocalAnalysisFrame.class);

    private LocalAnalysisPanel localAnalysisPanel;

    public LocalAnalysisFrame() {
        this.localAnalysisPanel = new LocalAnalysisPanel();
        createFrame();
    }

    private void createFrame() {
        this.setTitle("Local Analysis");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(650, 500);
        this.setResizable(false);
        this.add(this.localAnalysisPanel);
    }

}
