package lk.ijse.gdse.aad68.studentmanagecrudaad.dto;


import jakarta.servlet.ServletException;
import lk.ijse.gdse.aad68.studentmanagecrudaad.controller.StudentDTO;
import lk.ijse.gdse.aad68.studentmanagecrudaad.util.Util;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//
//        }
//        BufferedReader reader = req.getReader();
//        StringBuilder sb = new StringBuilder();
//        reader.lines().forEach(line -> sb.append(line).append("\n"));
//
//        System.out.println(sb.toString());

//        var id = req.getParameter("id");
//        var name = req.getParameter("name");
//        var email = req.getParameter("email");
//        var city = req.getParameter("city");
//        var level = req.getParameter("level");
//
//        System.out.println("ID : " + id);
//        System.out.println("Name : " + name);
//        System.out.println("E-mail : " + email);
//        System.out.println("City : " + city);
//        System.out.println("Level : " + level);
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
    //Process the jason

//    JsonReader reader = Json.createReader(req.getReader());
//    JsonObject jsonObject = reader.readObject();
//    String email = jsonObject.getString("email");
//    System.out.println(email);

    // Send data to the client

//    var writer = resp.getWriter();
//    writer.write(email);

    //Optional -jason Array processing
//    JsonArray jsonArray = reader.readArray();
//    for (int i = 0; i <jsonArray.size(); i++) {
//        JsonObject object = jsonArray.getJsonObject(i);
//        System.out.println(object.getString("name"));
//        System.out.println(object.getString("email"));
//
//    }

    //Object binding of the JSON
    Jsonb jsnob = JsonbBuilder.create();
    StudentDTO student = jsnob.fromJson(req.getReader(),StudentDTO.class);
    student.setId(Util.idGenerate());
    System.out.println("ok now Response created ");
    //create Response
    resp.setContentType("application/json");
    jsnob.toJson(student,resp.getWriter());
}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
    }
}
