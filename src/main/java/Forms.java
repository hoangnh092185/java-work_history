public class Forms {
  private String mJob;
  private String mTitle;
  private String mCompany;
  private String mStartDate;
  private String mEndDate;
  private String[] mJobRef;

  public Forms (String job, String title, String company, String startDate, String endDate){
    mJob = job;
    mTitle = title;
    mCompany = company;
    mStartDate = startDate;
    mEndDate = endDate;
  }
  public String getJob(){
    return mJob;
  }
  public String getTitle(){
    return mTitle;
  }
  public String getCompany(){
    return mCompany;
  }
  public String getStartDate(){
    return mStartDate;
  }
  public String getEndDate(){
    return mEndDate;
  }
}
