package ma.integration.batch.model;

public class JobCsvReader {

	private String jobName;
	private String oDate;
	private String orderId;
	private String startTime;
	private String endTime;
	private String status;
	private String averageRunTime;
	private String deleted;
	private String rerunCount;

	public JobCsvReader() {
		super();
	}

	public JobCsvReader(String jobName, String oDate, String orderId, String startTime, String endTime, String status,
			String averageRunTime, String deleted, String rerunCount) {
		super();
		this.jobName = jobName;
		this.oDate = oDate;
		this.orderId = orderId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.averageRunTime = averageRunTime;
		this.deleted = deleted;
		this.rerunCount = rerunCount;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getoDate() {
		return oDate;
	}

	public void setoDate(String oDate) {
		this.oDate = oDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAverageRunTime() {
		return averageRunTime;
	}

	public void setAverageRunTime(String averageRunTime) {
		this.averageRunTime = averageRunTime;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getRerunCount() {
		return rerunCount;
	}

	public void setRerunCount(String rerunCount) {
		this.rerunCount = rerunCount;
	}

	@Override
	public String toString() {
		return "JobCsvReader [jobName=" + jobName + ", oDate=" + oDate + ", orderId=" + orderId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", status=" + status + ", averageRunTime=" + averageRunTime
				+ ", deleted=" + deleted + ", rerunCount=" + rerunCount + "]";
	}
	
	

}