package ru.mygraphes;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class GraphesButton {
    BitmapFont font;
    String text;
    float x;
    float y;
    float width;
    float height;

    public GraphesButton(BitmapFont font, String text, float x, float y) {
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
        GlyphLayout glyphLayout = new GlyphLayout(font, text);
        width = glyphLayout.width;
        height = glyphLayout.height;
    }

    public boolean hit(float tx, float ty) {
        return x < tx && tx < x + width && y > ty && ty > y - height;
    }
}
