package testes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Handle with logs
 * @author enrique.alves
 */
public class LogsPan {
	private String client;
	private String contextPath;
	private OutputStream outputStream;
	private OutputStreamWriter osWriter;
	private String now;
	private Class<?> sourceClass;

	private final String separator = "_";
	private final String fileExtension = ".log";
	private final String dateFormat = "yyyy_MM_dd";
	private static final String SUCCESS = "SUCESSO";
	private static final String ERROR = "FALHA";
	
	Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
	private Logger logger = LoggerFactory.getLogger(sourceClass);
    
	public LogsPan(String client, String contextPath, Class<?> sourceClass) {
		this.client = client;
		this.contextPath = contextPath;
		this.sourceClass = sourceClass;
	}

	private void  getLogConstructor(final String name) throws Throwable {
		outputStream = new FileOutputStream(new File(getPath(name)), true);
		osWriter = new OutputStreamWriter(outputStream);
	}
	
	private void log(final String message, final String type) throws Throwable {
		getLogConstructor(type);
		logger(message, type);
		now = sdf.format(cal.getTime());
		osWriter.write("[" + now + "] "+ message);
		osWriter.write("\n");
		finalize();
	}
	
	/**
	 * 
	 * @param message a text to write on file
	 * @throws Throwable 
	 */
	public void logSuccess(final String message) throws Throwable {
		log(message, SUCCESS);
	}

	/**
	 * 
	 * @param message a text to write on file
	 * @throws Throwable 
	 */
	public void logError(final String message) throws Throwable {
		log(message, ERROR);
	}

	private Logger logger(String message, String type) {
		if (type == ERROR) {
			logger.error(message);
		} else if (type == SUCCESS) {
			logger.info(message);
		} else {
			logger.debug(message);
		}
		return logger;
	}
	private String getPath(final String name) {
		final String path = new StringBuffer().append(contextPath).append(File.separator).append(client).append(separator)
				.append(getFormatedDate()).append(separator).append(name).append(fileExtension).toString();
		return path;
	}

	private String getFormatedDate() {
		return new SimpleDateFormat(dateFormat).format(new Date());
	}
	
	@Override
	protected void finalize() throws Throwable {
		osWriter.close();
	}
}