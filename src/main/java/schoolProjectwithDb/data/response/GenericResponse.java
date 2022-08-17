package schoolProjectwithDb.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {

  private HttpStatus httpStatus;
  private String message;
  private Object body;

}
