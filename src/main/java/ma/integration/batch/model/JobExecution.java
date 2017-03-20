package ma.integration.batch.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobExecution implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String jobId; //l'Id est constitué du jobName_Odate_OrderId
	private String jobName;
	private String oDate;
	private String orderId;
	private String startTime;
	private String endTime;
	private String status;
	private String averageRunTime;
	private Boolean deleted;
	private Integer rerunCount;
	
	public JobExecution() {}

	public JobExecution(String jobName, String oDate, String orderId, String startTime, String endTime,
			String status, String averageRunTime, Boolean deleted, Integer rerunCount) {
		super();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(jobName);
		stringBuilder.append("_");
		stringBuilder.append(oDate);
		stringBuilder.append("_");
		stringBuilder.append(orderId);
		this.jobId = stringBuilder.toString();
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

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getRerunCount() {
		return rerunCount;
	}

	public void setRerunCount(Integer rerunCount) {
		this.rerunCount = rerunCount;
	}

	@Override
	public String toString() {
		return "JobExecution [jobId=" + jobId + ", jobName=" + jobName + ", oDate=" + oDate + ", orderId=" + orderId
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", status=" + status + ", averageRunTime="
				+ averageRunTime + ", deleted=" + deleted + ", rerunCount=" + rerunCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averageRunTime == null) ? 0 : averageRunTime.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result + ((oDate == null) ? 0 : oDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((rerunCount == null) ? 0 : rerunCount.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobExecution other = (JobExecution) obj;
		if (averageRunTime == null) {
			if (other.averageRunTime != null)
				return false;
		} else if (!averageRunTime.equals(other.averageRunTime))
			return false;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (oDate == null) {
			if (other.oDate != null)
				return false;
		} else if (!oDate.equals(other.oDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (rerunCount == null) {
			if (other.rerunCount != null)
				return false;
		} else if (!rerunCount.equals(other.rerunCount))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}	
}
