import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import lombok.Delegate;
import lombok.NonNull;
import lombok.SneakyThrows;

public class OriginFilterForFrontend implements OriginFilter {

  @Delegate
  private final OriginFilter.Default defaultOriginFilter;

  @SneakyThrows(MalformedURLException.class)
  public OriginFilterForFrontend(@NonNull String frontendDomain) throws MalformedURLException {
      defaultOriginFilter = new OriginFilter.Default(
		  Arrays.asList(new URL("https://www." + frontendDomain), new URL("https://" + frontendDomain)),
		  Arrays.asList("localhost", "0.0.0.0", "127.0.0.1")
	  );
  }


}