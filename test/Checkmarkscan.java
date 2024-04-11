package com.theice.gis.web;

import com.theice.gis.util.GISLog;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Checkmarkscan {
    @RequestMapping(value = "/checkmark")
    public String viewGISLandingPage(HttpServletRequest request, HttpServletResponse response, Model model)
             {
        try {
            String username = request.getParameter("username");
//            Connection conn = DriverManager.getConnection("jdbc:", username, "password");
// Create a statement from database connection
            Statement statement = conn.createStatement();
// Create unsafe query by concatenating user defined data with query string
            String query = "SELECT secret FROM Users WHERE (username = '" + username + "' AND NOT role = 'admin')";

            ResultSet result = statement.executeQuery(query);
        } catch (Exception e) {
            GISLog.error(e.getMessage());
        }
        return null;
    }
}
