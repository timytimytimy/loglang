package org.loglang.filter;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by liumiao on 16-5-15.
 */
public class FilterNode {
    private String opt;
    private String regex;
    private List<FilterNode> group;
    private boolean _valid;

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public List<FilterNode> getGroup() {
        return group;
    }

    public void setGroup(List<FilterNode> group) {
        this.group = group;
    }

    private boolean hasChild() {
        return this.group != null && this.group.size() > 0;
    }

    public boolean valid(String text) {
        if (this.hasChild()) {
            boolean v = false;
            if (this.opt.equalsIgnoreCase("and")) {
                v = true;
                for (FilterNode node : this.group) {
                    v = v && node.valid(text);
                }
            } else if (this.opt.equalsIgnoreCase("or")) {
                v = false;
                for (FilterNode node : this.group) {
                    v = v || node.valid(text);
                }
            }
            return v;
        } else {
            Pattern p = Pattern.compile(this.regex);
            this._valid = p.matcher(text).find();
            return this._valid;
        }
    }
}
