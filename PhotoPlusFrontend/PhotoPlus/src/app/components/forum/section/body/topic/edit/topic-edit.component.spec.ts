import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TopicEditComponent } from './topic-edit.component';

describe('TopicEditComponent', () => {
  let component: TopicEditComponent;
  let fixture: ComponentFixture<TopicEditComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ TopicEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopicEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
