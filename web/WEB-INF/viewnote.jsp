<%-- 
    Document   : viewnote
    Created on : Jun 8, 2021, 11:39:45 PM
    Author     : 839217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab 3</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><strong>Title: </strong> ${note.title}</p>
        <p><strong>Contents:</strong><br /> ${note.content} </p>
        <a href="note?edit">Edit</a>
    </body>
</html>