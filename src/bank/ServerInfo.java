package bank;

public class ServerInfo {

	private String ipAddress;
	private int port;
	
	public ServerInfo(String ipAddress, int port) {
		super();
		this.ipAddress = ipAddress;
		this.port = port;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServerInfo [");
		if (ipAddress != null) {
			builder.append("ipAddress=");
			builder.append(ipAddress);
			builder.append(", ");
		}
		builder.append("port=");
		builder.append(port);
		builder.append("]");
		return builder.toString();
	}
	
}
