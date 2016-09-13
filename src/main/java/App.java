import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main (String[] args) {
    staticFileLocation("/public"); //for image files
    String layout = "templates/layout.vtl";

    get("/", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("JobsList", request.session().attribute("JobsList"));
      model.put("template", "templates/formInput.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/Forms", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Forms> jobList = request.session().attribute("JobsList");
      if (jobList == null){
        jobList = new ArrayList<Forms>();
        request.session().attribute("Jobslist", jobList);
      }
      String stringJob = request.queryParams("job");
      String stringTitle = request.queryParams("title");
      String stringCompany = request.queryParams("company");
      String stringStartDate = request.queryParams("startDate");
      String stringEndDate = request.queryParams("endDate");
      Forms newRefList = new Forms(stringJob, stringTitle, stringCompany, stringStartDate, stringEndDate);

      model.put("template", "templates/JobsList.vtl");
      model.put("joblist", stringCompany);
      jobList.add(newRefList);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
