package ru.bmstu.ORM.Analyzer.Lexer;

import ru.bmstu.ORM.Analyzer.Service.Position;
import ru.bmstu.ORM.Analyzer.Symbols.Tokens.*;

import java.util.ArrayList;

public class Scanner {
    private Position cur;
    private ArrayList<Message> messages;

    public Scanner(String program) {
        this.cur = new Position(program);
        this.messages = new ArrayList<>();
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public Token nextToken() throws CloneNotSupportedException {
        while (!cur.isEOF()) {
            while (cur.isWhiteSpace())
                cur.nextCp();

            Position start = (Position) cur.clone();
            StringBuilder value;

            switch (cur.getChar()) {
                case 'a':
                   value = new StringBuilder("a");
                   cur.nextCp();
                   if (cur.getChar() == 'n') {
                       value.append("n");
                       cur.nextCp();
                       if (cur.getChar() == 'd') {
                           value.append("d");
                           cur.nextCp();
                           if (cur.isWhiteSpace() || cur.isSpecial())
                               return new KeywordToken(start, (Position) cur.clone(), TokenTag.AND);
                           else
                               return getIdent(start, value.toString());
                       }
                   } else if (cur.getChar() == 'c') {
                       value.append("c");
                       cur.nextCp();
                       if (cur.getChar() == 't') {
                           value.append("t");
                           cur.nextCp();
                           if (cur.getChar() == 'i') {
                               value.append("i");
                               cur.nextCp();
                               if (cur.getChar() == 'o') {
                                   value.append("o");
                                   cur.nextCp();
                                   if (cur.getChar() == 'n') {
                                       value.append("n");
                                       cur.nextCp();
                                       if (cur.isWhiteSpace() || cur.isSpecial())
                                           return new KeywordToken(start, (Position) cur.clone(), TokenTag.ACTION);
                                       else
                                           return getIdent(start, value.toString());
                                   }
                               }
                           }
                       }
                   }

                   return getIdent(start, value.toString());

                case 'b':
                    value = new StringBuilder("b");
                    cur.nextCp();
                    if (cur.getChar() == 'e') {
                        value.append("e");
                        cur.nextCp();
                        if (cur.getChar() == 't') {
                            value.append("t");
                            cur.nextCp();
                            if (cur.getChar() == 'w') {
                                value.append("w");
                                cur.nextCp();
                                if (cur.getChar() == 'e') {
                                    value.append("e");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.getChar() == 'n') {
                                            value.append("n");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.BETWEEN);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        }
                    } else if (cur.getChar() == 'i') {
                        value.append("i");
                        cur.nextCp();
                        if (cur.getChar() == 'g') {
                            value.append("g");
                            cur.nextCp();
                            if (cur.getChar() == 'i') {
                                value.append("i");
                                cur.nextCp();
                                if (cur.getChar() == 'n') {
                                    value.append("n");
                                    cur.nextCp();
                                    if (cur.getChar() == 't') {
                                        value.append("t");
                                        cur.nextCp();
                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.BIGINT);
                                        else
                                            return getIdent(start, value.toString());
                                    }
                                }
                            }
                        }
                    } else if (cur.getChar() == 'o') {
                        value.append("o");
                        cur.nextCp();
                        if (cur.getChar() == 'o') {
                            value.append("o");
                            cur.nextCp();
                            if (cur.getChar() == 'l') {
                                value.append('l');
                                cur.nextCp();
                                if (cur.getChar() == 'e') {
                                    value.append("e");
                                    cur.nextCp();
                                    if (cur.getChar() == 'a') {
                                        value.append("a");
                                        cur.nextCp();
                                        if (cur.getChar() == 'n') {
                                            value.append("n");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.BOOLEAN);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'c':
                    value = new StringBuilder("c");
                    cur.nextCp();
                    if (cur.getChar() == 'a') {
                        value.append("a");
                        cur.nextCp();
                        if (cur.getChar() == 's') {
                            value.append("s");
                            cur.nextCp();
                            if (cur.getChar() == 'c') {
                                value.append("c");
                                cur.nextCp();
                                if (cur.getChar() == 'a') {
                                    value.append("a");
                                    cur.nextCp();
                                    if (cur.getChar() == 'd') {
                                        value.append("d");
                                        cur.nextCp();
                                        if (cur.getChar() == 'e') {
                                            value.append("e");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.CASCADE);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        }
                    } else if (cur.getChar() == 'h') {
                        value.append("h");
                        cur.nextCp();
                        if (cur.getChar() == 'a') {
                            value.append("a");
                            cur.nextCp();
                            if (cur.getChar() == 'r') {
                                value.append("r");
                                cur.nextCp();
                                if (cur.getChar() == 'a') {
                                    value.append("a");
                                    cur.nextCp();
                                    if (cur.getChar() == 'c') {
                                        value.append("c");
                                        cur.nextCp();
                                        if (cur.getChar() == 't') {
                                            value.append("t");
                                            cur.nextCp();
                                            if (cur.getChar() == 'e') {
                                                value.append('e');
                                                cur.nextCp();
                                                if (cur.getChar() == 'r') {
                                                    value.append('r');
                                                    cur.nextCp();
                                                    if (cur.isWhiteSpace() || cur.isSpecial())
                                                        return new KeywordToken(start, (Position) cur.clone(), TokenTag.CHARACTER);
                                                    else
                                                        return getIdent(start, value.toString());
                                                }
                                            }
                                        }
                                    }
                                } else if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.CHAR);
                                else
                                    return getIdent(start, value.toString());
                            }
                        } else if (cur.getChar() == 'e') {
                            value.append("e");
                            cur.nextCp();
                            if (cur.getChar() == 'c') {
                                value.append("c");
                                cur.nextCp();
                                if (cur.getChar() == 'k') {
                                    value.append("k");
                                    cur.nextCp();
                                    if (cur.isWhiteSpace() || cur.isSpecial())
                                        return new KeywordToken(start, (Position) cur.clone(), TokenTag.CHECK);
                                    else
                                        return getIdent(start, value.toString());
                                }
                            }
                        }
                    } else if (cur.getChar() == 'o') {
                        value.append("o");
                        cur.nextCp();
                        if (cur.getChar() == 'n') {
                            value.append("n");
                            cur.nextCp();
                            if (cur.getChar() == 's') {
                                value.append("s");
                                cur.nextCp();
                                if (cur.getChar() == 't') {
                                    value.append("t");
                                    cur.nextCp();
                                    if (cur.getChar() == 'r') {
                                        value.append("r");
                                        cur.nextCp();
                                        if (cur.getChar() == 'a') {
                                            value.append("a");
                                            cur.nextCp();
                                            if (cur.getChar() == 'i') {
                                                value.append("i");
                                                cur.nextCp();
                                                if (cur.getChar() == 'n') {
                                                    value.append("n");
                                                    cur.nextCp();
                                                    if (cur.getChar() == 't') {
                                                        value.append("t");
                                                        cur.nextCp();
                                                        if (cur.isWhiteSpace() || cur.isSpecial()) {
                                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.CONSTRAINT);
                                                        } else
                                                            return getIdent(start, value.toString());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (cur.getChar() == 'r') {
                        value.append("r");
                        cur.nextCp();
                        if (cur.getChar() == 'e') {
                            value.append("e");
                            cur.nextCp();
                            if (cur.getChar() == 'a') {
                                value.append("a");
                                cur.nextCp();
                                if (cur.getChar() == 't') {
                                    value.append("t");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.CREATE);
                                        else
                                            return getIdent(start, value.toString());
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'd':
                    value = new StringBuilder("d");
                    cur.nextCp();
                    if (cur.getChar() == 'a') {
                        value.append("a");
                        cur.nextCp();
                        if (cur.getChar() == 't') {
                            value.append("t");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.DATE);
                                else
                                    return getIdent(start, value.toString());
                            }
                        }
                    } else if (cur.getChar() == 'e') {
                        value.append("e");
                        cur.nextCp();
                        if (cur.getChar() == 'c') {
                            value.append("c");
                            cur.nextCp();
                            if (cur.getChar() == 'i') {
                                value.append("i");
                                cur.nextCp();
                                if (cur.getChar() == 'm') {
                                    value.append("m");
                                    cur.nextCp();
                                    if (cur.getChar() == 'a') {
                                        value.append("a");
                                        cur.nextCp();
                                        if (cur.getChar() == 'l') {
                                            value.append("l");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.DECIMAL);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        } else if (cur.getChar() == 'f') {
                            value.append("f");
                            cur.nextCp();
                            if (cur.getChar() == 'a') {
                                value.append("a");
                                cur.nextCp();
                                if (cur.getChar() == 'u') {
                                    value.append("u");
                                    cur.nextCp();
                                    if (cur.getChar() == 'l') {
                                        value.append("l");
                                        cur.nextCp();
                                        if (cur.getChar() == 't') {
                                            value.append("t");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.DEFAULT);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        } else if (cur.getChar() == 'l') {
                            value.append("l");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.getChar() == 't') {
                                    value.append("t");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.DELETE);
                                        else
                                            return getIdent(start, value.toString());
                                    }
                                }
                            }
                        }
                    } else if (cur.getChar() == 'o') {
                        value.append("o");
                        cur.nextCp();
                        if (cur.getChar() == 'u') {
                            value.append("u");
                            cur.nextCp();
                            if (cur.getChar() == 'b') {
                                value.append("b");
                                cur.nextCp();
                                if (cur.getChar() == 'l') {
                                    value.append("l");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.DOUBLE);
                                        else
                                            return getIdent(start, value.toString());
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'e':
                    value = new StringBuilder("e");
                    cur.nextCp();
                    if (cur.getChar() == 'x') {
                        value.append("x");
                        cur.nextCp();
                        if (cur.getChar() == 'i') {
                            value.append("i");
                            cur.nextCp();
                            if (cur.getChar() == 's') {
                                value.append("s");
                                cur.nextCp();
                                if (cur.getChar() == 't') {
                                    value.append("t");
                                    cur.nextCp();
                                    if (cur.getChar() == 's') {
                                        value.append("s");
                                        cur.nextCp();
                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.EXISTS);
                                        else
                                            return getIdent(start, value.toString());
                                    }
                                }
                            }
                        }
                    } else if (cur.getChar() == 'l') {
                        value.append("l");
                        cur.nextCp();
                        if (cur.getChar() == 's') {
                            value.append("s");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.ELSE);
                                else
                                    return getIdent(start, value.toString());
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'f':
                    value = new StringBuilder("f");
                    cur.nextCp();
                    if (cur.getChar() == 'a') {
                        value.append("a");
                        cur.nextCp();
                        if (cur.getChar() == 'l') {
                            value.append("l");
                            cur.nextCp();
                            if (cur.getChar() == 's') {
                                value.append("s");
                                cur.nextCp();
                                if (cur.getChar() == 'e') {
                                    value.append("e");
                                    cur.nextCp();
                                    if (cur.isWhiteSpace() || cur.isSpecial())
                                        return new KeywordToken(start, (Position) cur.clone(), TokenTag.FALSE);
                                    else
                                        return getIdent(start, value.toString());
                                }
                            }
                        }
                    } else if (cur.getChar() == 'l') {
                        value.append("l");
                        cur.nextCp();
                        if (cur.getChar() == 'o') {
                            value.append("o");
                            cur.nextCp();
                            if (cur.getChar() == 'a') {
                                value.append("a");
                                cur.nextCp();
                                if (cur.getChar() == 't') {
                                    value.append('t');
                                    cur.nextCp();
                                    if (cur.isWhiteSpace() || cur.isSpecial())
                                        return new KeywordToken(start, (Position) cur.clone(), TokenTag.FLOAT);
                                    else
                                        return getIdent(start, value.toString());
                                }
                            }
                        }
                    } else if (cur.getChar() == 'o') {
                        value.append("o");
                        cur.nextCp();
                        if (cur.getChar() == 'r') {
                            value.append("r");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.getChar() == 'i') {
                                    value.append("i");
                                    cur.nextCp();
                                    if (cur.getChar() == 'g') {
                                        value.append("g");
                                        cur.nextCp();
                                        if (cur.getChar() == 'n') {
                                            value.append("n");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.FOREIGN);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'i':
                    value = new StringBuilder("i");
                    cur.nextCp();
                    if (cur.getChar() == 'f') {
                        value.append("f");
                        cur.nextCp();
                        if (cur.isWhiteSpace() || cur.isSpecial())
                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.IF);
                        else
                            return getIdent(start, value.toString());
                    } else if (cur.getChar() == 'n') {
                        value.append("n");
                        cur.nextCp();
                        if (cur.getChar() == 'h') {
                            value.append("h");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.getChar() == 'r') {
                                    value.append("r");
                                    cur.nextCp();
                                    if (cur.getChar() == 'i') {
                                        value.append("i");
                                        cur.nextCp();
                                        if (cur.getChar() == 't') {
                                            value.append("t");
                                            cur.nextCp();
                                            if (cur.getChar() == 's') {
                                                value.append("s");
                                                cur.nextCp();
                                                if (cur.isWhiteSpace() || cur.isSpecial())
                                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.INHERITS);
                                                else
                                                    return getIdent(start, value.toString());
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (cur.getChar() == 't') {
                            value.append("t");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.getChar() == 'g') {
                                    value.append("g");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.getChar() == 'r') {
                                            value.append("r");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.INTEGER);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            } else if (cur.isWhiteSpace() || cur.isSpecial())
                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.INT);
                            else
                                return getIdent(start, value.toString());
                        }
                    } else if (cur.getChar() == 's') {
                        value.append("s");
                        cur.nextCp();
                        if (cur.isWhiteSpace() || cur.isSpecial())
                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.IS);
                        else
                            return getIdent(start, value.toString());
                    }

                    return getIdent(start, value.toString());

                case 'k':
                    value = new StringBuilder("k");
                    cur.nextCp();
                    if (cur.getChar() == 'e') {
                        value.append("e");
                        cur.nextCp();
                        if (cur.getChar() == 'y') {
                            value.append("y");
                            cur.nextCp();
                            if (cur.isWhiteSpace() || cur.isSpecial())
                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.KEY);
                            else
                                return getIdent(start, value.toString());
                        }
                    }

                    return getIdent(start, value.toString());

                case 'l':
                    value = new StringBuilder("l");
                    cur.nextCp();
                    if (cur.getChar() == 'i') {
                        value.append("i");
                        cur.nextCp();
                        if (cur.getChar() == 'k') {
                            value.append("k");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.LIKE);
                                else
                                    return getIdent(start, value.toString());
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'n':
                    value = new StringBuilder("n");
                    cur.nextCp();
                    if (cur.getChar() == 'o') {
                        value.append('o');
                        cur.nextCp();
                        if (cur.getChar() == 't') {
                            value.append("t");
                            cur.nextCp();
                            if (cur.isWhiteSpace() || cur.isSpecial())
                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.NOT);
                            else
                                return getIdent(start, value.toString());
                        } else if (cur.isWhiteSpace() || cur.isSpecial())
                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.NO);
                        else
                            return getIdent(start, value.toString());
                    } else if (cur.getChar() == 'u') {
                        value.append('u');
                        cur.nextCp();
                        if (cur.getChar() == 'l') {
                            value.append("l");
                            cur.nextCp();
                            if (cur.getChar() == 'l') {
                                value.append("l");
                                cur.nextCp();
                                if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.NULL);
                                else
                                    return getIdent(start, value.toString());
                            }
                        } else if (cur.getChar() == 'm') {
                            value.append("m");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.getChar() == 'r') {
                                    value.append("r");
                                    cur.nextCp();
                                    if (cur.getChar() == 'i') {
                                        value.append("i");
                                        cur.nextCp();
                                        if (cur.getChar() == 'c') {
                                            value.append("c");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.NUMERIC);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'o':
                    value = new StringBuilder("o");
                    cur.nextCp();
                    if (cur.getChar() == 'n') {
                        value.append("n");
                        cur.nextCp();
                        if (cur.isWhiteSpace() || cur.isSpecial())
                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.ON);
                        else
                            return getIdent(start, value.toString());
                    } else if (cur.getChar() == 'r') {
                        value.append("r");
                        cur.nextCp();
                        if (cur.isWhiteSpace() || cur.isSpecial())
                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.OR);
                        else
                            return getIdent(start, value.toString());
                    }

                    return getIdent(start, value.toString());

                case 'p':
                    value = new StringBuilder("p");
                    cur.nextCp();
                    if (cur.getChar() == 'r') {
                        value.append("r");
                        cur.nextCp();
                        if (cur.getChar() == 'e') {
                            value.append("e");
                            cur.nextCp();
                            if (cur.getChar() == 'c') {
                                value.append("c");
                                cur.nextCp();
                                if (cur.getChar() == 'i') {
                                    value.append("i");
                                    cur.nextCp();
                                    if (cur.getChar() == 's') {
                                        value.append("s");
                                        cur.nextCp();
                                        if (cur.getChar() == 'i') {
                                            value.append("i");
                                            cur.nextCp();
                                            if (cur.getChar() == 'o') {
                                                value.append("o");
                                                cur.nextCp();
                                                if (cur.getChar() == 'n') {
                                                    value.append("n");
                                                    cur.nextCp();
                                                    if (cur.isWhiteSpace() || cur.isSpecial())
                                                        return new KeywordToken(start, (Position) cur.clone(), TokenTag.PRECISION);
                                                    else
                                                        return getIdent(start, value.toString());
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (cur.getChar() == 'i') {
                                value.append("i");
                                cur.nextCp();
                                if (cur.getChar() == 'm') {
                                    value.append("m");
                                    cur.nextCp();
                                    if (cur.getChar() == 'a') {
                                        value.append("a");
                                        cur.nextCp();
                                        if (cur.getChar() == 'r') {
                                            value.append("r");
                                            cur.nextCp();
                                            if (cur.getChar() == 'y') {
                                                value.append("y");
                                                cur.nextCp();
                                                if (cur.isWhiteSpace() || cur.isSpecial())
                                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.PRIMARY);
                                                else
                                                    return getIdent(start, value.toString());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'r':
                    value = new StringBuilder("r");
                    cur.nextCp();
                    if (cur.getChar() == 'e') {
                        value.append("e");
                        cur.nextCp();
                        if (cur.getChar() == 'a') {
                            value.append("a");
                            cur.nextCp();
                            if (cur.getChar() == 'l') {
                                value.append("l");
                                cur.nextCp();
                                if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.REAL);
                                else
                                    return getIdent(start, value.toString());
                            }
                        } else if (cur.getChar() == 'f') {
                            value.append("f");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.getChar() == 'r') {
                                    value.append("r");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.getChar() == 'n') {
                                            value.append("n");
                                            cur.nextCp();
                                            if (cur.getChar() == 'c') {
                                                value.append("c");
                                                cur.nextCp();
                                                if (cur.getChar() == 'e') {
                                                    value.append("e");
                                                    cur.nextCp();
                                                    if (cur.getChar() == 's') {
                                                        value.append("s");
                                                        cur.nextCp();
                                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.REFERENCES);
                                                        else
                                                            return getIdent(start, value.toString());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (cur.getChar() == 's') {
                            value.append("s");
                            cur.nextCp();
                            if (cur.getChar() == 't') {
                                value.append("t");
                                cur.nextCp();
                                if (cur.getChar() == 'r') {
                                    value.append("r");
                                    cur.nextCp();
                                    if (cur.getChar() == 'i') {
                                        value.append("i");
                                        cur.nextCp();
                                        if (cur.getChar() == 'c') {
                                            value.append("c");
                                            cur.nextCp();
                                            if (cur.getChar() == 't') {
                                                value.append("t");
                                                cur.nextCp();
                                                if (cur.isWhiteSpace() || cur.isSpecial())
                                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.RESTRICT);
                                                else
                                                    return getIdent(start, value.toString());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 's':
                    value = new StringBuilder("s");
                    cur.nextCp();
                    if (cur.getChar() == 'e') {
                        value.append("e");
                        cur.nextCp();
                        if (cur.getChar() == 't') {
                            value.append("t");
                            cur.nextCp();
                            if (cur.isWhiteSpace() || cur.isSpecial())
                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.SET);
                            else
                                return getIdent(start, value.toString());
                        }
                    } else if (cur.getChar() == 'm') {
                        value.append("m");
                        cur.nextCp();
                        if (cur.getChar() == 'a') {
                            value.append("a");
                            cur.nextCp();
                            if (cur.getChar() == 'l') {
                                value.append("l");
                                cur.nextCp();
                                if (cur.getChar() == 'l') {
                                    value.append("l");
                                    cur.nextCp();
                                    if (cur.getChar() == 'i') {
                                        value.append("i");
                                        cur.nextCp();
                                        if (cur.getChar() == 'n') {
                                            value.append("n");
                                            cur.nextCp();
                                            if (cur.getChar() == 't') {
                                                value.append("t");
                                                cur.nextCp();
                                                if (cur.isWhiteSpace() || cur.isSpecial())
                                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.SMALLINT);
                                                else
                                                    return getIdent(start, value.toString());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 't':
                    value = new StringBuilder("t");
                    cur.nextCp();
                    if (cur.getChar() == 'a') {
                        value.append("a");
                        cur.nextCp();
                        if (cur.getChar() == 'b') {
                            value.append("b");
                            cur.nextCp();
                            if (cur.getChar() == 'l') {
                                value.append("l");
                                cur.nextCp();
                                if (cur.getChar() == 'e') {
                                    value.append("e");
                                    cur.nextCp();
                                    if (cur.isWhiteSpace() || cur.isSpecial())
                                        return new KeywordToken(start, (Position) cur.clone(), TokenTag.TABLE);
                                    else
                                        return getIdent(start, value.toString());
                                }
                            }
                        }
                    } else if (cur.getChar() == 'h') {
                        value.append("h");
                        cur.nextCp();
                        if (cur.getChar() == 'e') {
                            value.append("e");
                            cur.nextCp();
                            if (cur.getChar() == 'n') {
                                value.append("n");
                                cur.nextCp();
                                if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.THEN);
                                else
                                    return getIdent(start, value.toString());
                            }
                        }
                    } else if (cur.getChar() == 'i') {
                        value.append("i");
                        cur.nextCp();
                        if (cur.getChar() == 'm') {
                            value.append("m");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.getChar() == 's') {
                                    value.append("s");
                                    cur.nextCp();
                                    if (cur.getChar() == 't') {
                                        value.append("t");
                                        cur.nextCp();
                                        if (cur.getChar() == 'a') {
                                            value.append("a");
                                            cur.nextCp();
                                            if (cur.getChar() == 'm') {
                                                value.append("m");
                                                cur.nextCp();
                                                if (cur.getChar() == 'p') {
                                                    value.append("p");
                                                    cur.nextCp();
                                                    if (cur.isWhiteSpace() || cur.isSpecial())
                                                        return new KeywordToken(start, (Position) cur.clone(), TokenTag.TIMESTAMP);
                                                    else
                                                        return getIdent(start, value.toString());
                                                }
                                            }
                                        }
                                    }
                                } else if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.TIME);
                                else
                                    return getIdent(start, value.toString());
                            }
                        }
                    } else if (cur.getChar() == 'r') {
                        value.append("r");
                        cur.nextCp();
                        if (cur.getChar() == 'u') {
                            value.append("u");
                            cur.nextCp();
                            if (cur.getChar() == 'e') {
                                value.append("e");
                                cur.nextCp();
                                if (cur.isWhiteSpace() || cur.isSpecial())
                                    return new KeywordToken(start, (Position) cur.clone(), TokenTag.TRUE);
                                else
                                    return getIdent(start, value.toString());
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'u':
                    value = new StringBuilder("u");
                    cur.nextCp();
                    if (cur.getChar() == 'n') {
                        value.append("n");
                        cur.nextCp();
                        if (cur.getChar() == 'i') {
                            value.append("i");
                            cur.nextCp();
                            if (cur.getChar() == 'q') {
                                value.append("q");
                                cur.nextCp();
                                if (cur.getChar() == 'u') {
                                    value.append("u");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.UNIQUE);
                                        else
                                            return getIdent(start, value.toString());
                                    }
                                }
                            }
                        }
                    } else if (cur.getChar() == 'p') {
                        value.append("p");
                        cur.nextCp();
                        if (cur.getChar() == 'd') {
                            value.append("d");
                            cur.nextCp();
                            if (cur.getChar() == 'a') {
                                value.append("a");
                                cur.nextCp();
                                if (cur.getChar() == 't') {
                                    value.append("t");
                                    cur.nextCp();
                                    if (cur.getChar() == 'e') {
                                        value.append("e");
                                        cur.nextCp();
                                        if (cur.isWhiteSpace() || cur.isSpecial())
                                            return new KeywordToken(start, (Position) cur.clone(), TokenTag.UPDATE);
                                        else
                                            return getIdent(start, value.toString());
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case 'v':
                    value = new StringBuilder("v");
                    cur.nextCp();
                    if (cur.getChar() == 'a') {
                        value.append("a");
                        cur.nextCp();
                        if (cur.getChar() == 'r') {
                            value.append("r");
                            cur.nextCp();
                            if (cur.getChar() == 'c') {
                                value.append("c");
                                cur.nextCp();
                                if (cur.getChar() == 'h') {
                                    value.append("h");
                                    cur.nextCp();
                                    if (cur.getChar() == 'a') {
                                        value.append("a");
                                        cur.nextCp();
                                        if (cur.getChar() == 'r') {
                                            value.append("r");
                                            cur.nextCp();
                                            if (cur.isWhiteSpace() || cur.isSpecial())
                                                return new KeywordToken(start, (Position) cur.clone(), TokenTag.VARCHAR);
                                            else
                                                return getIdent(start, value.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return getIdent(start, value.toString());

                case '(':
                    cur.nextCp();

                    return new LParenToken(start, (Position) cur.clone());
                case ')':
                    cur.nextCp();

                    return new RParenToken(start, (Position) cur.clone());
                case '<':
                    cur.nextCp();
                    if (cur.getChar() == '=') {
                        cur.nextCp();

                        return new ComparisonToken(TokenTag.LESSEQ, start, (Position) cur.clone(), "<=");
                    } else

                        return new ComparisonToken(TokenTag.LESS, start, (Position) cur.clone(), "<");
                case '>':
                    cur.nextCp();
                    if (cur.getChar() == '=') {
                        cur.nextCp();

                        return new ComparisonToken(TokenTag.GREATEREQ, start, (Position) cur.clone(), ">=");
                    } else

                        return new ComparisonToken(TokenTag.GREATER, start, (Position) cur.clone(), ">");
                case '=':
                    cur.nextCp();

                    return new ComparisonToken(TokenTag.EQUAL, start, (Position) cur.clone(), "=");
                case '!':
                    cur.nextCp();
                    if (cur.getChar() == '=') {
                        cur.nextCp();
                    } else {
                        messages.add(new Message((Position) cur.clone(), "'=' expected"));
                    }

                    return new ComparisonToken(TokenTag.NOTEQUAL, start, (Position) cur.clone(), "!=");
                case '+':
                    cur.nextCp();

                    return new ArithmeticOpToken(TokenTag.ADD, start, (Position) cur.clone(), '+');
                case '-':
                    cur.nextCp();
                    if (cur.getChar() == '-') {
                        while (cur.getChar() != '\n')
                            cur.nextCp();

                        continue;
                    }

                    return new ArithmeticOpToken(TokenTag.SUB, start, (Position) cur.clone(), '-');
                case '*':
                    cur.nextCp();

                    return new ArithmeticOpToken(TokenTag.MUL, start, (Position) cur.clone(), '*');
                case '/':
                    cur.nextCp();

                    return new ArithmeticOpToken(TokenTag.DIV, start, (Position) cur.clone(), '/');
                case '\'':
                    value = new StringBuilder();
                    cur.nextCp();
                    while (cur.getChar() != '\'') {
                        if (cur.getChar() == '\n' || cur.getChar() == '\r')
                            messages.add(new Message((Position) cur.clone(), "String must be in one line"));
                        else
                            value.append(cur.getChar());

                        cur.nextCp();
                    }

                    cur.nextCp();

                    return new StringToken(start, (Position) cur.clone(), value.toString());
                case ',':
                    cur.nextCp();

                    return new CommaToken(start, (Position) cur.clone());
                case '.':
                    cur.nextCp();

                    return new DotToken(start, (Position) cur.clone());

                default:
                   if (cur.isLetter())
                       return getIdent(start, "");
                   else if (cur.isDigit()) {
                       Token number = getNumber(start);
                       if (number != null)
                           return number;
                   }
//                   else {
//                       messages.add(new Message((Position) cur.clone(), "Unrecognizable token"));
//                   }
            }
        }

        return new EOFToken(cur);
    }

    private IdentToken getIdent(Position start, String value) throws CloneNotSupportedException {
        StringBuilder valueBuilder = new StringBuilder(value);
        while (cur.isLetterOrDigit()) {
            valueBuilder.append(cur.getChar());
            cur.nextCp();
        }

        value = valueBuilder.toString();

        return new IdentToken(start, (Position) cur.clone(), value);
    }

    private NumberToken getNumber(Position start) throws CloneNotSupportedException {
        StringBuilder value = new StringBuilder();
        boolean wasComma = false;
        while (cur.isDigit() || cur.getChar() == '.') {
            if (cur.getChar() == '.') {
                if (wasComma)
                    messages.add(new Message((Position) cur.clone(), "Two dots in float number"));
                else
                    wasComma = true;
            }

            value.append(cur.getChar());
            cur.nextCp();
        }

        if (wasComma) {
            try {
                Float number = Float.parseFloat(value.toString());
                return new NumberToken(TokenTag.FLOAT_CONST, start, (Position) cur.clone(), number);
            } catch (NumberFormatException ef) {
                try {
                    Double number = Double.parseDouble(value.toString());
                    return new NumberToken(TokenTag.DOUBLE_CONST, start, (Position) cur.clone(), number);
                } catch (NumberFormatException ed) {
                    messages.add(new Message((Position) cur.clone(), "Wrong number"));
                    return null;
                }
            }
        } else {
            try {
                Byte number = Byte.parseByte(value.toString());
                return new NumberToken(TokenTag.BYTE_CONST, start, (Position) cur.clone(), number);
            } catch (NumberFormatException eb) {
                try {
                    Short number = Short.parseShort(value.toString());
                    return new NumberToken(TokenTag.SHORT_CONST, start, (Position) cur.clone(), number);
                } catch (NumberFormatException es) {
                    try {
                        Integer number = Integer.parseInt(value.toString());
                        return new NumberToken(TokenTag.INT_CONST, start, (Position) cur.clone(), number);
                    } catch (NumberFormatException ei) {
                        try {
                            Long number = Long.parseLong(value.toString());
                            return new NumberToken(TokenTag.LONG_CONST, start, (Position) cur.clone(), number);
                        } catch (NumberFormatException el) {
                            messages.add(new Message((Position) cur.clone(), "Wrong number"));
                            return null;
                        }
                    }
                }
            }
        }
    }
}
