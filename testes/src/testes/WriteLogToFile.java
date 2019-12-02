package testes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Handle with logs
 * @author enrique.alves
 */
public class WriteLogToFile {
	private String client;
	private String contextPath;
	private FileHandler fh;
	private Class<?> sourceClass;

	private final String separator = "_";
	private final String fileExtension = ".log";
	private final String dateFormat = "yyyy_MM_dd";
	private final String SUCCESS = "SUCESSO";
	private final String ERROR = "FALHA";

	public WriteLogToFile(String client, String contextPath, Class<?> sourceClass) {
		this.client = client;
		this.contextPath = contextPath;
		this.sourceClass = sourceClass;
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
	
	private void log(final String message, final String type) throws Throwable {
		final Logger logger = getLogConstructor(type);
		logger.info(message);
		finalize();
	}

	private Logger getLogConstructor(final String name) throws Throwable {
		fh = new FileHandler(getPath(name), true);
		fh.setFormatter(new SimpleFormatter());
		final Logger logger = Logger.getLogger(sourceClass.getName());
		logger.addHandler(fh);
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
		fh.close();
	}
}