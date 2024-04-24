package com.speedhire.selenium.server;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

public class FeeAnalyticsServlet extends HttpServlet {
    public static final String footer = "</table>\n" +
            "</div>\n" +
            "<!--Students Data-->\n" +
            "<footer>2023-2024</footer>\n" +
            "</body>\n" +
            "</html>";

    private static final String head = "<html>\n" +
            "<head>\n" +
            "    <title>Fee Analytics Application</title>\n" +
            "<style>\n" +
            "body{margin:0; padding:24px;}\n" +
            "    table{padding: 0; margin: 0; width: 100%; text-align: left; border-collapse:collapse;}\n" +
            "    table th{background:#f1f1f1;}\n" +
            "    table td,table th{padding:4px; border:solid 1px #dadada;}\n" +
            "    footer{padding:24px; text-align:center; border-top:solid 1px #999; background:#dadada; margin-top:40px;}\n" +
            "</style>" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Fee Analytics Application</h1>\n" +
            "\n" +
            "<div class=\"mx-auto w-50 mt-100 paragraph\">\n" +
            "    <p>Jetty server has been started to serve.</p>\n" +
            "</div>\n" +
            "\n" +
            "<!--Students Data-->\n" +
            "<div align=\"center\">\n" +
            "    <table>";

    private static Integer studentSeed = 0;
    private static Integer feeSeed = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Server->Processing URL: " + request.getRequestURL());

        response.setHeader("Cache-Control", "private, no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setCharacterEncoding("UTF-8");

        StringBuilder builder = new StringBuilder();
        builder.append(head);

        if ("/seed".equals(request.getRequestURI())) {
            studentSeed = Integer.parseInt(request.getParameter("studentSeed"));
            feeSeed = Integer.parseInt(request.getParameter("feeSeed"));
        } else if ("/students".equals(request.getRequestURI())) {
            builder.append("<tr>");
            builder.append("<th>");
            builder.append("Student Id");
            builder.append("</th>");

            builder.append("<th>");
            builder.append("Name");
            builder.append("</th>");

            builder.append("<th>");
            builder.append("Department Id");
            builder.append("</th>");

            builder.append("<th>");
            builder.append("Annual Fee");
            builder.append("</th>");

            builder.append("</tr>");

            for (int i = 1; i <= studentSeed; i++) {
                builder.append("<tr>");

                builder.append("<td>");
                builder.append(i);
                builder.append("</td>");

                builder.append("<td>");
                builder.append(RandomStringUtils.random(i + 5, "abcdefghij"));
                builder.append("</td>");

                builder.append("<td>");
                builder.append(i + 20);
                builder.append("</td>");

                builder.append("<td>");
                builder.append("<a href=\"payment?p=" + i + "\">");
                builder.append(feeSeed + i);
                builder.append("</a>");
                builder.append("</td>");

                builder.append("</tr>");
            }
        } else if ("/payment".equals(request.getRequestURI())) {
            Integer p = Integer.parseInt(request.getParameter("p"));
            Integer amount = (feeSeed + p) / p;

            builder.append("<tr>");
            builder.append("<th>");
            builder.append("Student Id");
            builder.append("</th>");

            builder.append("<th>");
            builder.append("Receipt ID");
            builder.append("</th>");

            builder.append("<th>");
            builder.append("Paid Amount");
            builder.append("</th>");

            for (int j = 1; j <= p; j++) {
                builder.append("<tr>");
                builder.append("<td>");
                builder.append(p);
                builder.append("</td>");
                builder.append("<td>");
                builder.append(j);
                builder.append("</td>");
                builder.append("<td>");
                builder.append(amount);
                builder.append("</td>");

                builder.append("</tr>");
            }
        }

        builder.append(footer);
        response.getWriter().write(builder.toString());
    }
}
