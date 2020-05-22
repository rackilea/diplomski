public class ReportTripSingle implements java.io.Serializable {

@Id
@Column(name = "TRE_ID", precision = 10, scale = 0)
private long id;

@Column(name = "TRE_FTP_ID", length = 15, nullable = false, precision = 10, scale = 0, insertable = false, updatable = false)
private long tripDataId;

@Column(name = "TRE_BATCH_ID", nullable = false, insertable = false, updatable = false)
private long tripBatchId;

@Column(name = "TRE_FTP_DEP_DAY", nullable = false,insertable = false, updatable = false)
private long tripDay;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumns({
        @JoinColumn(name = "TRE_FTP_ID", referencedColumnName = "FTP_ID"),
        @JoinColumn(name = "TRE_BATCH_ID", referencedColumnName = "FTP_BATCH_ID"),
        @JoinColumn(name = "TRE_FTP_DEP_DAY", referencedColumnName = "FTP_DAY")

})
private TripData tripData;
}