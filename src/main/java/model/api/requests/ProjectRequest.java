package model.api.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectRequest {
    private String title;
    private String code;
    private String description;
    private String access;
    private String group;
}
