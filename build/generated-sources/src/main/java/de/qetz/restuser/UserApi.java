/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package de.qetz.restuser;

import de.qetz.restuser.UserCreationDto;
import de.qetz.restuser.UserDto;
import de.qetz.restuser.UserEmailUpdateDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-11T14:32:25.409171200+02:00[Europe/Berlin]")

@Validated
@Api(value = "user", description = "the user API")
public interface UserApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /user : Create a new user
     *
     * @param userCreationDto Payload used to create a new user entry (required)
     * @return The created user entry (status code 200)
     */
    @ApiOperation(value = "Create a new user", nickname = "createUser", notes = "", response = UserDto.class, authorizations = {
        @Authorization(value = "OAuth2", scopes = {
            @AuthorizationScope(scope = "user_create", description = "Create a user")
            })
    }, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The created user entry", response = UserDto.class) })
    @RequestMapping(value = "/user",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<UserDto> createUser(@ApiParam(value = "Payload used to create a new user entry" ,required=true )  @Valid @RequestBody UserCreationDto userCreationDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"UserId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : 0, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /user/{id} : Delete a user
     *
     * @param id The unique id of a user (required)
     * @return User deleted (status code 204)
     *         or User deletion failed due to resource dependencies (status code 409)
     */
    @ApiOperation(value = "Delete a user", nickname = "deleteUser", notes = "", authorizations = {
        @Authorization(value = "OAuth2", scopes = {
            @AuthorizationScope(scope = "user_delete", description = "Delete a user")
            })
    }, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "User deleted"),
        @ApiResponse(code = 409, message = "User deletion failed due to resource dependencies") })
    @RequestMapping(value = "/user/{id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteUser(@ApiParam(value = "The unique id of a user",required=true) @PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/{id} : Get certain user
     *
     * @param id The unique id of a user (required)
     * @return User info (status code 200)
     */
    @ApiOperation(value = "Get certain user", nickname = "findUser", notes = "", response = UserDto.class, authorizations = {
        @Authorization(value = "OAuth2", scopes = {
            @AuthorizationScope(scope = "user_info", description = "Shows info of a user")
            })
    }, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User info", response = UserDto.class) })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<UserDto> findUser(@ApiParam(value = "The unique id of a user",required=true) @PathVariable("id") Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"UserId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : 0, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /user/{id} : Update a user
     *
     * @param id The unique id of a user (required)
     * @param userEmailUpdateDto Email used to update a user entry (optional)
     * @return Updated user info (status code 200)
     */
    @ApiOperation(value = "Update a user", nickname = "updateUser", notes = "", response = UserDto.class, authorizations = {
        @Authorization(value = "OAuth2", scopes = {
            @AuthorizationScope(scope = "user_update", description = "Update a user")
            })
    }, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated user info", response = UserDto.class) })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<UserDto> updateUser(@ApiParam(value = "The unique id of a user",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Email used to update a user entry"  )  @Valid @RequestBody(required = false) UserEmailUpdateDto userEmailUpdateDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"UserId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : 0, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
