package com.wuyuncheng.xpress.model.param;

import com.wuyuncheng.xpress.model.entity.Post;
import com.wuyuncheng.xpress.model.enums.PostType;
import com.wuyuncheng.xpress.util.validator.PostSlugValidation;
import com.wuyuncheng.xpress.util.validator.PostStatusValidation;
import com.wuyuncheng.xpress.util.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@ApiModel
@Data
public class PostParam {

    @ApiModelProperty("文章状态")
    @NotBlank(message = "文章状态不能为空")
    @PostStatusValidation
    @Size(max = 50, message = "文章状态长度不能超过 {max}")
    private String status;

    @ApiModelProperty("文章作者 ID")
    @NotNull(message = "文章作者 ID 不能为空")
    @Digits(integer = 20, fraction = 0)
    private Integer authorId;

    @ApiModelProperty("文章分类 ID")
    @NotNull(message = "文章分类 ID 不能为空")
    @Digits(integer = 20, fraction = 0)
    private Integer categoryId;

    @ApiModelProperty("文章标题")
    @NotBlank(message = "文章标题不能为空")
    @Size(max = 200, message = "文章标题长度不能超过 {max} 字符")
    private String title;

    @ApiModelProperty("文章内容")
    @NotBlank(message = "文章内容不能为空")
    private String content;

    @ApiModelProperty("文章缩略名")
    @PostSlugValidation
    @Size(max = 200, message = "文章缩略名长度不能超过 {max} 字符")
    private String slug;

    @ApiModelProperty("是否允许评论")
    @NotNull(message = "是否允许评论不能为空")
    private Boolean isAllowComments;

    @ApiModelProperty("文章标签")
    private Set<String> tags;

    public Post convertTo() {
        Post post = new Post();
        BeanUtils.copyProperties(this, post);
        post.setType(PostType.POST.getValue());
        post.setModified(DateUtils.nowUnix());
        return post;
    }

}
