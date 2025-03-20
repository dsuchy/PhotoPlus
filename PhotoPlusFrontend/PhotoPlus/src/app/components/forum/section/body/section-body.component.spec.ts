import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { SectionBodyComponent } from './section-body.component';

describe('SectionBodyComponent', () => {
  let component: SectionBodyComponent;
  let fixture: ComponentFixture<SectionBodyComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ SectionBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SectionBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
