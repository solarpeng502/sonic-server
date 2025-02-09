package org.cloud.sonic.common.models.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import org.cloud.sonic.common.models.base.TypeConverter;
import org.cloud.sonic.common.models.dto.GlobalParamsDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author JayWenStar
 * @since 2021-12-17
 */
@ApiModel(value = "GlobalParams对象", description = "")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("global_params")
@TableComment("全局参数表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class GlobalParams implements Serializable, TypeConverter<GlobalParams, GlobalParamsDTO> {

    @TableId(value = "id", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;

    @TableField
    @Column(value = "params_key", isNull = false, comment = "参数key")
    private String paramsKey;

    @TableField
    @Column(value = "params_value", isNull = false, comment = "参数value")
    private String paramsValue;

    @TableField
    @Column(value = "project_id", isNull = false, comment = "所属项目id")
    @Index(value = "IDX_PROJECT_ID", columns = {"project_id"})
    private Integer projectId;
}
